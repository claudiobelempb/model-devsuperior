package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryFindAll;

import br.sub.com.projectmodel.modules.product.dto.ProductCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryFindAllResource {

  @Autowired
  private ProductCategoryFindAllService service;

  @GetMapping
  public ResponseEntity<List<ProductCategoryDTO>> handle(){
    List<ProductCategoryDTO> dto = service.execute();
    return ResponseEntity.ok().body(dto);
  }
}
