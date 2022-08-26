package br.sub.com.projectmodel.modules.section.dto;

import br.sub.com.projectmodel.modules.resource.infra.entities.Resource;
import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class SectionDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String title;
  private String description;
  private Integer position;
  private String imgUrl;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private Resource resource;
  private Section prerequisite;

  public SectionDTO(){}

  public SectionDTO(Long id, String code, String title, String description, Integer position, String imgUrl,
                    TypeStatus status, Instant createdAt, Instant updatedAt, Resource resource, Section prerequisite) {
    this.id = id;
    this.code = code;
    this.title = title;
    this.description = description;
    this.position = position;
    this.imgUrl = imgUrl;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.resource = resource;
    this.prerequisite = prerequisite;
  }

  public SectionDTO(Section entity) {
    id = entity.getId();
    code = entity.getCode();
    title = entity.getTitle();
    description = entity.getDescription();
    position = entity.getPosition();
    imgUrl = entity.getImgUrl();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    resource = entity.getResource();
    prerequisite = entity.getPrerequisite();
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getPosition() {
    return position;
  }

  public void setPosition(Integer position) {
    this.position = position;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
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

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Resource getResource() {
    return resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  public Section getPrerequisite() {
    return prerequisite;
  }

  public void setPrerequisite(Section prerequisite) {
    this.prerequisite = prerequisite;
  }
}
