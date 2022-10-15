package br.sub.com.projectmodel.modules.product.usecase.Product.ProductSpecification;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import br.sub.com.projectmodel.modules.product.specification.ProductSpecification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductSpecificationService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductSpecification specification;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute( ProductDTO filter, Pageable pageable){
    Page<Product> entity = productRepository.findAll(specification.execute(filter), pageable);
    return entity.map(dto -> new ProductDTO(dto));
  }

}
