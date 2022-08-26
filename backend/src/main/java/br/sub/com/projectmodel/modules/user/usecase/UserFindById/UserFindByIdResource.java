package br.sub.com.projectmodel.modules.user.usecase.UserFindById;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserFindByIdResource {

  @Autowired
  private UserFindByIdService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> handle(@PathVariable Long id){
    UserDTO dto = service.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
