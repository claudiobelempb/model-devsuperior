package br.sub.com.projectmodel.modules.notification.usecase.NotificationFindById;

import br.sub.com.projectmodel.modules.notification.dto.NotificationDTO;
import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.modules.notification.infra.repositories.NotificationRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class NotificationFindByIdService {

  @Autowired
  private NotificationRepository repository;

  @Transactional(readOnly = true)
  public NotificationDTO execute(Long id){
    Optional<Notification> obj = repository.findById(id);
    Notification notification = obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND));
    return new NotificationDTO(notification);
  }

}
