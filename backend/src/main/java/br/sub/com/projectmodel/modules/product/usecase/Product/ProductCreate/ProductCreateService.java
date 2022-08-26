package br.sub.com.projectmodel.modules.product.usecase.Product.ProductCreate;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import br.sub.com.projectmodel.modules.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductCategoryRepository categoryRepository;
  @Autowired
  private ProductMapper productMapper;

  @Transactional
  public ProductDTO execute(ProductDTO dto){
    Product entity = new Product();
    productMapper.mapperCreateProduct(dto, entity);

    entity = productRepository.save(entity);
    return new ProductDTO(entity);
  }
}
