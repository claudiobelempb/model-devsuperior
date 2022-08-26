package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryDelete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class ProductCategoryDeleteResource {

  @Autowired
  private ProductCategoryDeleteService service;

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id){
    service.execute(id);
    return ResponseEntity.noContent().build();
  }
}
