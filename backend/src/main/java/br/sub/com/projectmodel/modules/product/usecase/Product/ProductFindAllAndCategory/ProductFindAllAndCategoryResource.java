package br.sub.com.projectmodel.modules.product.usecase.Product.ProductFindAllAndCategory;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.usecase.Product.ProductFindAllPage.ProductFindAllPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductFindAllAndCategoryResource {
  @Autowired
  private ProductFindAllAndCategoryService service;

  @GetMapping(value = "/search")
  public ResponseEntity<Page<ProductDTO>> handle(
    @RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
    @RequestParam(value = "name", defaultValue = "") String name,
    @RequestParam(value = "page", defaultValue = "0") Integer page,
    @RequestParam(value = "linesPerPegae", defaultValue = "12") Integer linesPerPegae,
    @RequestParam(value = "direction", defaultValue = "ASC") String direction,
    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    PageRequest pageRequest = PageRequest.of(page, linesPerPegae, Sort.Direction.valueOf(direction), orderBy);
    Page<ProductDTO> dto = service.execute(categoryId, name.trim(), pageRequest);
    return ResponseEntity.ok().body(dto);
  }
}
