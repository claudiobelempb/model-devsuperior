package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryFindAll;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductCategoryFindAllService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public List<ProductCategoryDTO> execute(){
    List<ProductCategory> categories = repository.findAll();
    return categories.stream().map(category -> new ProductCategoryDTO(category)).toList();
  }
}
