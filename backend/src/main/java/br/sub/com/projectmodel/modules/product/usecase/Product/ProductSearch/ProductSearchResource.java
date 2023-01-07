package br.sub.com.projectmodel.modules.product.usecase.Product.ProductSearch;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.dto.ProductNameProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductSearchResource {
  @Autowired
  private ProductSearchService service;

  @GetMapping(value = "/pagnation")
  public ResponseEntity<Page<ProductDTO>> haldle(Pageable pageable){
    Page<ProductDTO> entity = service.execute(pageable);
    return ResponseEntity.ok().body(entity);
  }

  @Transactional(readOnly = true)
  @GetMapping(value = "/name/status{status}")
  public ResponseEntity<List<ProductNameProjectionDTO>> handle(@RequestParam(value = "status") Integer status){
    List<ProductNameProjectionDTO> dto = service.execute(status);
    return ResponseEntity.ok().body(dto);
  }
}
