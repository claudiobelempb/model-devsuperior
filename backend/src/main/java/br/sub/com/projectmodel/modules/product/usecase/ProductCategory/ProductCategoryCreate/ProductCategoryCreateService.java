package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryCreate;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryCreateService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional
  public ProductCategoryDTO execute(ProductCategoryDTO dto){
    ProductCategory entity = ProductCategoryMapper.mapperCreate(dto);
    entity = repository.save(entity);
    return new ProductCategoryDTO(entity);
  }

}
