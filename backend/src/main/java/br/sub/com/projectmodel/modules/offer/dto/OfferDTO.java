package br.sub.com.projectmodel.modules.offer.dto;

import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class OfferDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private Long id;
  private String code;
  private String edition;

  private Instant startMoment;

  private Instant endMoment;
  private EnumStatus status;

  private Instant createdAt;

  private Instant updatedAt;

  private Long courseId;

  public OfferDTO(){}

  public OfferDTO(Long id, String code, String edition, Instant startMoment, Instant endMoment, EnumStatus status,
                  Instant createdAt, Instant updatedAt, Long courseId) {
    this.id = id;
    this.code = code;
    this.edition = edition;
    this.startMoment = startMoment;
    this.endMoment = endMoment;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.courseId = courseId;
  }

  public OfferDTO(Offer entity){
    id = entity.getId();
    code = entity.getCode();
    edition = entity.getEdition();
    startMoment = entity.getStartMoment();
    endMoment = entity.getEndMoment();
    status = getStatus();
    createdAt = getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    courseId = entity.getCourse().getId();
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

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }


}
