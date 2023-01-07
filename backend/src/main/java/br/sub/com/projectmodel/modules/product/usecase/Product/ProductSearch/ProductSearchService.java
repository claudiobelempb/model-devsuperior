package br.sub.com.projectmodel.modules.product.usecase.Product.ProductSearch;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.dto.ProductNameProjectionDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import br.sub.com.projectmodel.modules.product.projections.ProductNameProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductSearchService {

  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public Page<ProductDTO>  execute(Pageable pageable){
    Page<Product> entity = repository.findAll(pageable);
    return entity.map(product -> new ProductDTO(product));
  }

  @Transactional(readOnly = true)
  public List<ProductNameProjectionDTO> execute(Integer status){
    List<ProductNameProjection> products = repository.findByNameProduct(status);
    return products.stream().map(product -> new ProductNameProjectionDTO(product)).toList();
  }

  @Transactional(readOnly = true)
  public List<ProductNameProjectionDTO> execute1(Integer status){
    List<ProductNameProjection> products = repository.findByNameProduct(status);
    return products.stream().map(product -> new ProductNameProjectionDTO(product)).toList();
  }

}
