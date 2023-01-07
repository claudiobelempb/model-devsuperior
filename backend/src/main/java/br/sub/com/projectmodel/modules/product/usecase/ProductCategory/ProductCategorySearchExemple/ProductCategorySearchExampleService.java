package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategorySearchExemple;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategorySearchExampleService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public Page<ProductCategoryDTO> execute(ProductCategory filter, Pageable pageable){
    ExampleMatcher matcher =
      ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
    Example<ProductCategory> example = Example.of(filter, matcher);
    Page<ProductCategory> entity = repository.findAll(example, pageable);
    return entity.map(dto -> new ProductCategoryDTO(dto));
  }
}
