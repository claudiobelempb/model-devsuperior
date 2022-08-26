package br.sub.com.projectmodel.modules.address.usecase.AddressCreate;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/address")
public class AddressCreateResource {

  @Autowired
  private AddressCreateService addressCreateService;

  @PostMapping
  public ResponseEntity<AddressDTO> handle(@RequestBody AddressDTO dto ){
    AddressDTO obj = addressCreateService.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

}
