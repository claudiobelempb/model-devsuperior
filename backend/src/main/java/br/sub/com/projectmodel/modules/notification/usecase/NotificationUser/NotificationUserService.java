package br.sub.com.projectmodel.modules.notification.usecase.NotificationUser;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.modules.notification.infra.repositories.NotificationRepository;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.usecase.UserAuthService.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationUserService {

  @Autowired
  private UserAuthService service;

  @Autowired
  private NotificationRepository repository;

  @Transactional(readOnly = true)
  public Page<NotificationDTO> execute(boolean unreadOnly, Pageable pageable){
    //04-24 Conteúdo customizado para usuário logado
    User user = service.authenticated();
    Page<Notification> notifications = repository.filterUnreadOnly(user, unreadOnly, pageable);
    return notifications.map(notification -> new NotificationDTO(notification));
  }
}
