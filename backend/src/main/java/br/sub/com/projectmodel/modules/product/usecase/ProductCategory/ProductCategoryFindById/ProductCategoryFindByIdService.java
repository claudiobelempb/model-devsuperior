package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryFindById;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductCategoryFindByIdService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional(readOnly = true)
  public ProductCategoryDTO execute(Long id) {
    Optional<ProductCategory> obj = repository.findById(id);
    ProductCategory entity = obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND));
    return new ProductCategoryDTO(entity);
  }
}
