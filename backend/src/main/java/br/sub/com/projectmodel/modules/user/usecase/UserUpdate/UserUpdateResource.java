package br.sub.com.projectmodel.modules.user.usecase.UserUpdate;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.dto.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserUpdateResource {

  @Autowired
  private UserUpdateService service;

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserDTO> handle(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto) {
    UserDTO obj = service.execute(id, dto);
    return ResponseEntity.ok().body(obj);
  }
}


