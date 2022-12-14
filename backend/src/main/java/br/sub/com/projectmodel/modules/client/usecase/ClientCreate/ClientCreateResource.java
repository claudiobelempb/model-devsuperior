package br.sub.com.projectmodel.modules.client.usecase.ClientCreate;

import br.sub.com.projectmodel.modules.client.dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientCreateResource {

  @Autowired
  private ClientCreateService service;
  @PostMapping
  public ResponseEntity<ClientDTO> handle(@RequestBody ClientDTO dto){
    ClientDTO obj = service.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }
}
