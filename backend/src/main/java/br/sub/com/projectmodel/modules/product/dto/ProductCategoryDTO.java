package br.sub.com.projectmodel.modules.product.dto;

import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductCategoryDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private EnumStatus status;

  private final List<ProductDTO> products = new ArrayList<>();

  public ProductCategoryDTO(){}

  public ProductCategoryDTO(Long id, String code, String name, Instant createdAt, Instant updatedAt,
                            EnumStatus status) {
    this.id = id;
    this.code = code;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
  }

  public ProductCategoryDTO(ProductCategory entity) {
    id = entity.getId();
    code = entity.getCode();
    name = entity.getName();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    status = entity.getStatus();
  }

  public ProductCategoryDTO(ProductCategory category, Set<Product> products) {
    this(category);
    products.forEach(product -> this.products.add(new ProductDTO(product)));
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

  public List<ProductDTO> getProducts() {
    return products;
  }
}
