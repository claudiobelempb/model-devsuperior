package br.sub.com.projectmodel.modules.product.usecase.ProductImage.ProductImageFindById;

import br.sub.com.projectmodel.modules.product.dto.ProductImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/images")
public class ProductImageFindByIdResource {
  @Autowired
  private ProductImageFindByIdService productImageFindByIdService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ProductImageDTO> handle(@PathVariable Long id){
    ProductImageDTO dto = productImageFindByIdService.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
