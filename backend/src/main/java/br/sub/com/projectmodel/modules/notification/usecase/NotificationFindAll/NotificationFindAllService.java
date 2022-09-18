package br.sub.com.projectmodel.modules.notification.usecase.NotificationFindAll;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.modules.notification.infra.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationFindAllService {

  @Autowired
  private NotificationRepository repository;

  @Transactional(readOnly = true)
  public Page<NotificationDTO> execute(Pageable pageable){
    Page<Notification> notifications = repository.findAll(pageable);
    return notifications.map(notification -> new NotificationDTO(notification));
  }

}
