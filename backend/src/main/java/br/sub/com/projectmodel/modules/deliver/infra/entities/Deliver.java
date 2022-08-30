package br.sub.com.projectmodel.modules.deliver.infra.entities;

import br.sub.com.projectmodel.modules.course.infra.entities.Course;
import br.sub.com.projectmodel.modules.enrollment.infra.entities.Enrollment;
import br.sub.com.projectmodel.modules.lesson.infra.entities.Lesson;
import br.sub.com.projectmodel.shared.enums.TypeDeliver;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_deliver")
public class Deliver implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String url;
  private String feedback;
  private Integer correctCount;
  private TypeDeliver status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumns({
    @JoinColumn(name = "offer_id"),
    @JoinColumn(name = "user_id")
  })
  private Enrollment enrollment;

  @ManyToOne
  @JoinColumn(name = "lesson_id")
  private Lesson lesson;

  public Deliver(){}

  public Deliver(Long id, String code, String url, String feedback, Integer correctCount, TypeDeliver status,
                 Instant createdAt, Instant updatedAt, Enrollment enrollment, Lesson lesson) {
    this.id = id;
    this.code = code;
    this.url = url;
    this.feedback = feedback;
    this.correctCount = correctCount;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.enrollment = enrollment;
    this.lesson = lesson;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public Integer getCorrectCount() {
    return correctCount;
  }

  public void setCorrectCount(Integer correctCount) {
    this.correctCount = correctCount;
  }

  public TypeDeliver getStatus() {
    return status;
  }

  public void setStatus(TypeDeliver status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }


  public Enrollment getEnrollment() {
    return enrollment;
  }

  public void setEnrollment(Enrollment enrollment) {
    this.enrollment = enrollment;
  }

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }

  @PrePersist
  public void prePersist(){
    code = UUID.randomUUID().toString();
    createdAt = Instant.now();
    status = TypeDeliver.PENDING;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Deliver deliver = (Deliver) o;

    return id.equals(deliver.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
