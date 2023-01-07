package br.sub.com.projectmodel.modules.product.usecase.Product.ProductFindAllPage;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductFindAllPageService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute( Long categoryID, String name, Pageable pageable){
    List<ProductCategory> categories = (categoryID == 0) ? null :
      Arrays.asList(categoryRepository.getReferenceById(categoryID));
    Page<Product> entity = productRepository.jpql(categories, name, pageable);
    return entity.map(dto -> new ProductDTO(dto));
  }

}
