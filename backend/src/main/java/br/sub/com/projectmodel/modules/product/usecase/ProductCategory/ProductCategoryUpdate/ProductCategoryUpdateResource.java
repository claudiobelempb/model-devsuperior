package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryUpdate;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryUpdateResource {

  @Autowired
  private ProductCategoryUpdateService service;

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductCategoryDTO> handle(@PathVariable Long id, @RequestBody ProductCategoryDTO dto) {
    dto = service.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }
}
