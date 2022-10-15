package br.sub.com.projectmodel.modules.product.usecase.Product.ProductFindAllAndCategory;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductFindAllAndCategoryService {

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ProductCategoryRepository categoryRepository;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute(Long categoryId, String name, PageRequest pageRequest){
    List<ProductCategory> categories = (categoryId == 0) ? null :
      List.of(categoryRepository.getReferenceById(categoryId));
    Page<Product> entity = productRepository.search(categories, name, pageRequest);
    productRepository.findProductsWithCategories(entity.getContent());
    productRepository.findProductsWithImages(entity.getContent());
    return entity.map(dto -> new ProductDTO(dto, dto.getCategories(), dto.getImages()));
  }

}
