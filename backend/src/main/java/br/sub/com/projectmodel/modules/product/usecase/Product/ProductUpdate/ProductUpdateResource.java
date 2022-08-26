package br.sub.com.projectmodel.modules.product.usecase.Product.ProductUpdate;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductUpdateResource {

  @Autowired
  private ProductUpdateServe productUpdateService;

  @PutMapping(value = "/{id}")
  public ResponseEntity<ProductDTO> handle(@Valid @PathVariable Long id, @RequestBody ProductDTO dto){
    dto = productUpdateService.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }

}
