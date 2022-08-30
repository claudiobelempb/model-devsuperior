package br.sub.com.projectmodel.modules.lesson.infra.entities;

import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import br.sub.com.projectmodel.modules.enrollment.infra.entities.Enrollment;
import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String title;
  private Integer position;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "section_id")
  private Section section;

  @ManyToMany
  @JoinTable(
    name = "tb_lessons_done_association",
    joinColumns = @JoinColumn(name = "lesson_id"),
    inverseJoinColumns = {
      @JoinColumn(name = "user_id"),
      @JoinColumn(name = "offer_id")
    }
  )
  private final Set<Enrollment> enrollmentsDone = new HashSet<>();

  @OneToMany(mappedBy = "lesson")
  private final List<Deliver> delivers = new ArrayList<>();

  public Lesson(){}

  public Lesson(Long id, String code, String title, Integer position, TypeStatus status, Instant createdAt,
                Instant updatedAt, Section section) {
    this.id = id;
    this.code = code;
    this.title = title;
    this.position = position;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.section = section;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public Set<Enrollment> getEnrollmentsDone() {
    return enrollmentsDone;
  }

  @PrePersist
  public void prePersist(){
    code = UUID.randomUUID().toString();
    createdAt = Instant.now();
    status = TypeStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Lesson lesson = (Lesson) o;

    return Objects.equals(id, lesson.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
