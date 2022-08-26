package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryStatus;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryStatusResource {

  @Autowired
  private ProductCategoryStatusService service;

  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody ProductCategoryDTO dto){
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }
}
