package br.sub.com.projectmodel.modules.product.infra.entities;

import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_product_category")
public class ProductCategory implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String name;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private EnumStatus status;

  @ManyToMany(mappedBy = "categories")
  private final Set<Product> products = new HashSet<>();

  public ProductCategory(){}

  public ProductCategory(Long id, String code, String name, Instant createdAt, Instant updatedAt, EnumStatus status) {
    this.id = id;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.code = code;
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public Set<Product> getProducts() {
    return products;
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
    ProductCategory that = (ProductCategory) o;
    return id.equals(that.id) && code.equals(that.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }
}
