package br.sub.com.projectmodel.modules.user.usecase.UserFindAllPage;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserFindAllPageResource {
  @Autowired
  private UserFindAllPageService service;

  @GetMapping
  public ResponseEntity<Page<UserDTO>> handle(Pageable pageable){
    Page<UserDTO> dto = service.execute(pageable);
    return ResponseEntity.ok().body(dto);
  }

}
