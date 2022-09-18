package br.sub.com.projectmodel.modules.notification.usecase.NotificationFindAll;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationFindAllResource {

  @Autowired
  private NotificationFindAllService service;

  @GetMapping
  public ResponseEntity<Page<NotificationDTO>> handle(Pageable pageable) {
    Page<NotificationDTO> page = service.execute(pageable);
    return ResponseEntity.ok().body(page);
  }
}
