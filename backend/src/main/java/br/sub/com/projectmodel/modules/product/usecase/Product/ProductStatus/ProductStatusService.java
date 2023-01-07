package br.sub.com.projectmodel.modules.product.usecase.Product.ProductStatus;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductStatusService {

  @Autowired
  private ProductRepository repository;

  @Transactional
  public void execute(Long id, ProductDTO dto){
    try{
      Product entity = repository.getReferenceById(id);
      entity.setStatus(dto.getStatus());
      repository.save(entity);
    }catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
