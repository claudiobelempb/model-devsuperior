package br.sub.com.projectmodel.modules.section.infra.entities;

import br.sub.com.projectmodel.modules.course.infra.entities.Course;
import br.sub.com.projectmodel.modules.resource.infra.entities.Resource;
import br.sub.com.projectmodel.shared.enums.EnumStatus;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_section")
public class Section implements Serializable {
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
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "resource_id")
  private Resource resource;

  /*uma auto associal com tb_section unilateral*/
  @ManyToOne
  @JoinColumn(name = "prerequisite_id")
  private Section prerequisite;

  public Section(){}

  public Section(Long id, String code, String title, String description, Integer position, String imgUrl,
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

  public Instant getUpdatedAt() {
    return updatedAt;
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

    Section section = (Section) o;

    return id.equals(section.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
