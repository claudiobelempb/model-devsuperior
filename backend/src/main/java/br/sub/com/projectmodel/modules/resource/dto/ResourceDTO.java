package br.sub.com.projectmodel.modules.resource.dto;

import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.dto.ProductImageDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductImage;
import br.sub.com.projectmodel.modules.resource.infra.entities.Resource;
import br.sub.com.projectmodel.modules.section.dto.SectionDTO;
import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeResource;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.Column;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ResourceDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String title;
  private String description;
  private Integer position;
  private String imgUrl;
  private TypeResource type;
  private String extemaLink;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private Offer offer;

  private final List<Section> sections = new ArrayList<>();

  public ResourceDTO(){}

  public ResourceDTO(Long id, String code, String title, String description, Integer position, String imgUrl,
                     TypeResource type, String extemaLink, TypeStatus status, Instant createdAt, Instant updatedAt,
                     Offer offer) {
    this.id = id;
    this.code = code;
    this.title = title;
    this.description = description;
    this.position = position;
    this.imgUrl = imgUrl;
    this.type = type;
    this.extemaLink = extemaLink;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.offer = offer;
  }

  public ResourceDTO(Resource entity){
    id = entity.getId();
    code = entity.getCode();
    title = entity.getTitle();
    description = entity.getDescription();
    position = entity.getPosition();
    imgUrl = entity.getImgUrl();
    type = entity.getType();
    extemaLink = entity.getExtemaLink();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    offer = entity.getOffer();
  }

  public ResourceDTO(Resource entity, Set<Section> sections) {
   this(entity);
    sections.forEach(section -> this.sections.add(new SectionDTO(section).getPrerequisite()));
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

  public TypeResource getType() {
    return type;
  }

  public void setType(TypeResource type) {
    this.type = type;
  }

  public String getExtemaLink() {
    return extemaLink;
  }

  public void setExtemaLink(String extemaLink) {
    this.extemaLink = extemaLink;
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


  public Offer getOffer() {
    return offer;
  }

  public List<Section> getSections() {
    return sections;
  }
}
