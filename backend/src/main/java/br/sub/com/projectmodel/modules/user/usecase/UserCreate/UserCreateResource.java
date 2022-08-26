package br.sub.com.projectmodel.modules.user.usecase.UserCreate;

import br.sub.com.projectmodel.modules.user.dto.UserCreateDTO;
import br.sub.com.projectmodel.modules.user.dto.UserDTO;
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
@RequestMapping(value = "/users")
public class UserCreateResource {

  @Autowired
  private UserCreateService service;

  @PostMapping
  public ResponseEntity<UserDTO> handle(@Valid @RequestBody UserCreateDTO dto){
    UserDTO obj = service.execute(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

}
