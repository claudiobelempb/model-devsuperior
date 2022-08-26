package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryCreate;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryCreateResource {

  @Autowired
  private ProductCategoryCreateService service;

  @PostMapping
  public ResponseEntity<ProductCategoryDTO> handle(@RequestBody ProductCategoryDTO dto){
    dto = service.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }
}
