package br.sub.com.projectmodel.modules.course.infra.entities;

import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_course")
public class Course implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String name;
  private String imgUrl;
  private String imgGrayUrl;
  private EnumStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  /*Um course pode ter 0 ou mais offers uma para nuitos*/
  @OneToMany(mappedBy = "course")
  private final List<Offer> offers = new ArrayList<>();

  public Course(){}

  public Course(Long id, String code, String name, String imgUrl, String imgGrayUrl, EnumStatus status,
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public List<Offer> getOffers() {
    return offers;
  }

  @PrePersist
  public void prePersist(){
    code = UUID.randomUUID().toString();
    createdAt = Instant.now();
    status = EnumStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Course course = (Course) o;
    return id.equals(course.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
