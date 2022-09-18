package br.sub.com.projectmodel.modules.offer.infra.entities;

import br.sub.com.projectmodel.modules.course.infra.entities.Course;
import br.sub.com.projectmodel.modules.resource.infra.entities.Resource;
import br.sub.com.projectmodel.modules.topic.infra.entities.Topic;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_offer")
public class Offer implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String edition;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant startMoment;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant endMoment;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  /*Um offer pode ter exatamente um course um para muitos */
  @ManyToOne
  @JoinColumn(name = "course_id")
  private Course course;

  @OneToMany(mappedBy = "offer")
  private final List<Resource> resources = new ArrayList<>();

  @OneToMany(mappedBy = "offer")
  private final List<Topic> topics = new ArrayList<>();

  public Offer(){}

  public Offer(Long id, String code, String edition, Instant startMoment, Instant endMoment, TypeStatus status,
               Instant createdAt, Instant updatedAt, Course course) {
    this.id = id;
    this.code = code;
    this.edition = edition;
    this.startMoment = startMoment;
    this.endMoment = endMoment;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.course = course;
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

  public String getEdition() {
    return edition;
  }

  public void setEdition(String edition) {
    this.edition = edition;
  }

  public Instant getStartMoment() {
    return startMoment;
  }

  public void setStartMoment(Instant startMoment) {
    this.startMoment = startMoment;
  }

  public Instant getEndMoment() {
    return endMoment;
  }

  public void setEndMoment(Instant endMoment) {
    this.endMoment = endMoment;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public List<Resource> getResources() {
    return resources;
  }

  public List<Topic> getTopics() {
    return topics;
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
    Offer offer = (Offer) o;
    return id.equals(offer.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
