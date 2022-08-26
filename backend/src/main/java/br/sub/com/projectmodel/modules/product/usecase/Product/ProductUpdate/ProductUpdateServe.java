package br.sub.com.projectmodel.modules.product.usecase.Product.ProductUpdate;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import br.sub.com.projectmodel.modules.product.mapper.ProductMapper;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductUpdateServe {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductMapper productMapper;

  @Transactional
  public ProductDTO execute(Long id, ProductDTO dto) {
    try {
      Product entity = productRepository.getReferenceById(id);
      productMapper.mapperCreateProduct(dto, entity);
      entity = productRepository.save(entity);
      return new ProductDTO(entity);
    } catch (EntityNotFoundException e){
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
