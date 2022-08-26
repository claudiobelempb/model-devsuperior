package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategorySearch;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import br.sub.com.projectmodel.modules.product.filter.ProductCategoryFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategorySearchResource {

  @Autowired
  private ProductCategorySearchService service;


  @GetMapping(value = "/search")
  public ResponseEntity<Page<ProductCategoryDTO>> handle(ProductCategoryFilter filter, Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<ProductCategoryDTO> dto = service.execute(filter, pageable);
    return ResponseEntity.ok().body(dto);
  }

}
