package br.sub.com.projectmodel.modules.address.usecase.AddressFindAllPage;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressFindAllPageResource {

  @Autowired
  private AddressFindAllPageService addressFindAllPageService;

  @GetMapping(value = "/page")
  public ResponseEntity<Page<AddressDTO>> handle(Pageable pageable)
  {
    /*PARAMETRISE: page, size, direction, sort*/
    Page<AddressDTO> dto = addressFindAllPageService.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }
}
