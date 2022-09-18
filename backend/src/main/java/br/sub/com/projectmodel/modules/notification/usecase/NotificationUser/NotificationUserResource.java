package br.sub.com.projectmodel.modules.notification.usecase.NotificationUser;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/notifications")
public class NotificationUserResource {

  @Autowired
  private NotificationUserService service;

  @GetMapping
  public ResponseEntity<Page<NotificationDTO>> handle(Pageable pageable){
    /*PARAMETRISE: page, size, sort*/
    Page<NotificationDTO> page = service.execute(pageable);
    return ResponseEntity.ok().body(page);
  }
}
