package br.sub.com.projectmodel.modules.course.dto;

import br.sub.com.projectmodel.modules.course.infra.entities.Course;
import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CourseDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String name;
  private String imgUrl;
  private String imgGrayUrl;
  private EnumStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  private final List<Offer> offers = new ArrayList<>();

  public CourseDTO(){}

  public CourseDTO(Long id, String code, String name, String imgUrl, String imgGrayUrl, EnumStatus status,
                   Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.imgUrl = imgUrl;
    this.imgGrayUrl = imgGrayUrl;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public CourseDTO(Course entity){
    id = entity.getId();
    code = entity.getCode();
    name = entity.getName();
    imgUrl = entity.getImgUrl();
    imgGrayUrl = entity.getImgGrayUrl();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();

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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getImgGrayUrl() {
    return imgGrayUrl;
  }

  public void setImgGrayUrl(String imgGrayUrl) {
    this.imgGrayUrl = imgGrayUrl;
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

  public List<Offer> getOffers() {
    return offers;
  }
}
