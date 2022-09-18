package br.sub.com.projectmodel.modules.notification.usecase.NotificationFindById;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationFindByIdResource {

  @Autowired
  private  NotificationFindByIdService service;


  @GetMapping(value = "/{id}")
  public ResponseEntity<NotificationDTO> handle(@PathVariable Long id){
    NotificationDTO dto = service.execute(id);
    return ResponseEntity.ok().body(dto);
  }
}
