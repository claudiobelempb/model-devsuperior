package br.sub.com.projectmodel.modules.product.usecase.Product.ProductStatus;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductStatusResource {
  @Autowired
  private ProductStatusService service;

  @PatchMapping(value = "/status/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody ProductDTO dto){
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }
}
