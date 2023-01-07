package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategorySearchExemple;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategorySearchExampleResource {

  @Autowired
  private ProductCategorySearchExampleService service;


  @GetMapping(value = "/search/example")
  public ResponseEntity<Page<ProductCategoryDTO>> handle(ProductCategory filter, Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<ProductCategoryDTO> dto = service.execute(filter, pageable);
    return ResponseEntity.ok().body(dto);
  }
}
