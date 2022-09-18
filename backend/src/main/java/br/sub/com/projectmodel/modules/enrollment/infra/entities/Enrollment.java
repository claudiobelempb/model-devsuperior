package br.sub.com.projectmodel.modules.enrollment.infra.entities;

import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import br.sub.com.projectmodel.modules.lesson.infra.entities.Lesson;
import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private final EnrollmentPK id = new EnrollmentPK();
  private String code;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant enrollMoment;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant refundMoment;
  private boolean available;
  private boolean onlyUpdate;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @OneToMany(mappedBy = "enrollment")
  private final List<Deliver> delivers = new ArrayList<>();

  @ManyToMany(mappedBy = "enrollmentsDone")
  private final Set<Lesson> lessonsDone = new HashSet<>();

  public Enrollment(){}

  public Enrollment(User user, Offer offer, String code,
    Instant enrollMoment, Instant refundMoment, boolean available,
                    boolean onlyUpdate,
                    TypeStatus status, Instant createdAt, Instant updatedAt) {
    id.setUser(user);
    id.setOffer(offer);
    this.code = code;
    this.enrollMoment = enrollMoment;
    this.refundMoment = refundMoment;
    this.available = available;
    this.onlyUpdate = onlyUpdate;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public User getUser(){
    return id.getUser();
  }

  public void setUser(User user){
    id.setUser(user);
  }

  public Offer getOffer(){
    return id.getOffer();
  }

  public void setOffer(Offer offer){
    id.setOffer(offer);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Instant getEnrollMoment() {
    return enrollMoment;
  }

  public void setEnrollMoment(Instant enrollMoment) {
    this.enrollMoment = enrollMoment;
  }

  public Instant getRefundMoment() {
    return refundMoment;
  }

  public void setRefundMoment(Instant refundMoment) {
    this.refundMoment = refundMoment;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public boolean isOnlyUpdate() {
    return onlyUpdate;
  }

  public void setOnlyUpdate(boolean onlyUpdate) {
    this.onlyUpdate = onlyUpdate;
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

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public List<Deliver> getDelivers() {
    return delivers;
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

    Enrollment that = (Enrollment) o;

    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
