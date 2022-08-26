package br.sub.com.projectmodel.modules.product.filter;

import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.time.Instant;

public class ProductCategoryFilter {

  private Long id;
  private String code;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private EnumStatus status;

  public ProductCategoryFilter(){}

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
}
