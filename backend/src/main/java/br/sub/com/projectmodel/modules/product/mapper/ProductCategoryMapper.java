package br.sub.com.projectmodel.modules.product.mapper;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductCategoryMapper {
  @Autowired
  private static ProductCategoryRepository repository;

  public static ProductCategory mapperCreate(ProductCategoryDTO dto){
    ProductCategory entity = new ProductCategory();
    entity.setName(dto.getName());
    return entity;
  }

  public static void mapperUpdate(ProductCategoryDTO dto, ProductCategory entity){
    entity.setName(dto.getName());
  }
}
