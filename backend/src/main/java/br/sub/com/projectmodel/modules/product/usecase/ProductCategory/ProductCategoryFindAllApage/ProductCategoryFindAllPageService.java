package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryFindAllApage;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCategoryFindAllPageService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public Page<ProductCategoryDTO> execute(Pageable pageable){
    Page<ProductCategory> entity = repository.findAll(pageable);
    return entity.map(category -> new ProductCategoryDTO(category));
  }

}
