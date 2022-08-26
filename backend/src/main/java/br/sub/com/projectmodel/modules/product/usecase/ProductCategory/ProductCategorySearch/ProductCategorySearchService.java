package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategorySearch;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.filter.ProductCategoryFilter;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.specification.ProductCategorySpecification.ProductCategorySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategorySearchService {

  @Autowired
  private ProductCategoryRepository repository;

  @Autowired
  private ProductCategorySpecification specification;

  @Transactional(readOnly = true)
  public Page<ProductCategoryDTO> execute(ProductCategoryFilter filter, Pageable pageable){
    Page<ProductCategory> entity = repository.findAll(specification.products(filter), pageable);
    return entity.map(dto -> new ProductCategoryDTO(dto));
  }

}
