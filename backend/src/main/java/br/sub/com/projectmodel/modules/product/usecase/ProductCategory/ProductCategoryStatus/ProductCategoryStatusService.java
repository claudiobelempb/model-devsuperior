package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryStatus;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductCategoryStatusService {

  @Autowired
  private ProductCategoryRepository repository;

  @Transactional
  public void execute(Long id, ProductCategoryDTO dto){
    try{
      ProductCategory entity = repository.getReferenceById(id);
      entity.setStatus(dto.getStatus());
      repository.save(entity);
    }catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
