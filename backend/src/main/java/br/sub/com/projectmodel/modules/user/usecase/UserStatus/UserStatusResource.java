package br.sub.com.projectmodel.modules.user.usecase.UserStatus;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserStatusResource {

  @Autowired
  private UserStatusService service;

  @PatchMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id, @RequestBody UserDTO dto) {
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }
}
