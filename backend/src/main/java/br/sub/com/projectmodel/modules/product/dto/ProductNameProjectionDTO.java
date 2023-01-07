package br.sub.com.projectmodel.modules.product.dto;

import br.sub.com.projectmodel.modules.product.projections.ProductNameProjection;
import br.sub.com.projectmodel.modules.user.projections.UserProjections;

public class ProductNameProjectionDTO {
  private String name;

  public ProductNameProjectionDTO(){}

  public ProductNameProjectionDTO(ProductNameProjection entity){
    name = entity.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ProductNameProjectionDTO{" +
      "name='" + name + '\'' +
      '}';
  }
}
