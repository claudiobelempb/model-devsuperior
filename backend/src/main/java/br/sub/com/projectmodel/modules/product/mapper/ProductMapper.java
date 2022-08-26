package br.sub.com.projectmodel.modules.product.mapper;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.dto.ProductImageDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductImage;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

  @Autowired
  private ProductCategoryRepository productCategoryRepository;

  @Autowired
  private ProductImageRepository productImageRepository;

  public void mapperCreateProduct(ProductDTO dto, Product product) {
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setPrice(dto.getPrice());

    product.getCategories().clear();
    product.getImages().clear();

    for(ProductImageDTO productImageDTO : dto.getImages()){
      ProductImage image = productImageRepository.getReferenceById(productImageDTO.getId());
      product.getImages().add(image);
    }

    for (ProductCategoryDTO productCategoryDTO : dto.getCategories()) {
      ProductCategory category = productCategoryRepository.getReferenceById(productCategoryDTO.getId());
      product.getCategories().add(category);
    }
  }

}
