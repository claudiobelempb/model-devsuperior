package br.sub.com.projectmodel.modules.product.usecase.Product.ProductSpecification;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductSpecificationResource {

  @Autowired
  private ProductSpecificationService service;

  @GetMapping(value = "/specification")
  public ResponseEntity<Page<ProductDTO>> handle(ProductDTO filter, Pageable pageable) {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<ProductDTO> dto = service.execute(filter, pageable);
    return ResponseEntity.ok().body(dto);
  }

}
