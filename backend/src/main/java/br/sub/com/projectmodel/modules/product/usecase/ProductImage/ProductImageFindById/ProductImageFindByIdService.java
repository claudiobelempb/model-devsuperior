package br.sub.com.projectmodel.modules.product.usecase.ProductImage.ProductImageFindById;

import br.sub.com.projectmodel.modules.product.dto.ProductImageDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductImage;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductImageRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductImageFindByIdService {

  @Autowired
  private ProductImageRepository productImageRepository;

  @Transactional(readOnly = true)
  public ProductImageDTO execute(Long id) {

    Optional<ProductImage> obj = productImageRepository.findById(id);
    ProductImage entity =
      obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id));
    return new ProductImageDTO(entity, entity.getProducts());
  }
}
