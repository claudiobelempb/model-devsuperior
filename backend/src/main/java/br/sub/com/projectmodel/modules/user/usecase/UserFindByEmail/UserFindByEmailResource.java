package br.sub.com.projectmodel.modules.user.usecase.UserFindByEmail;

import br.sub.com.projectmodel.modules.user.dto.UserProjectionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserFindByEmailResource {

  @Autowired
  private UserFindByEmailService service;

  @Transactional(readOnly = true)
  @GetMapping(value = "/{id}/{code}")
  public ResponseEntity<UserProjectionsDTO> handle(@PathVariable Long id, @PathVariable String code){
    UserProjectionsDTO dto = service.execute(id, code);
    return ResponseEntity.ok().body(dto);
  }
}
