package br.sub.com.projectmodel.modules.product.usecase.Product.ProductCreate;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductCreateResource {

  @Autowired
  private ProductCreateService service;

  @PostMapping
  public ResponseEntity<ProductDTO> handle(@Valid @RequestBody ProductDTO dto){
    ProductDTO productDTO = service.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(productDTO.getId()).toUri();
    return ResponseEntity.created(uri).body(productDTO);
  }
}
