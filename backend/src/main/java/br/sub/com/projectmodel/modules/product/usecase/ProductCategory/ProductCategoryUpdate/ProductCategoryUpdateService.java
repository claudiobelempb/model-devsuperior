package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryUpdate;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.mapper.ProductCategoryMapper;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductCategoryUpdateService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional
  public ProductCategoryDTO execute(Long id, ProductCategoryDTO dto){
    try {
      ProductCategory entity = repository.getReferenceById(id);
      ProductCategoryMapper.mapperUpdate(dto, entity);
      entity = repository.save(entity);
      return new ProductCategoryDTO(entity);
    } catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ID_NOT_FOUND + id);
    }
  }
}
