package br.sub.com.projectmodel.modules.resource.infra.entities;

import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeResource;
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
@Table(name = "tb_resource")
public class Resource implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  @ManyToOne
  @JoinColumn(name = "offer_id")
  private Offer offer;

  @OneToMany(mappedBy = "resource")
  private final List<Section> sections = new ArrayList<>();

  public Resource(){}

  public Resource(Long id, String code, String title, String description, Integer position, String imgUrl,
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

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

  public List<Section> getSections() {
    return sections;
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
    Resource resource = (Resource) o;
    return Objects.equals(id, resource.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
