package br.sub.com.projectmodel.modules.user.usecase.UserStatus;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class UserStatusService {

  @Autowired
  private UserRepository repository;

  @Transactional
  public void execute(Long id, UserDTO dto) {
    try{
      User entity = repository.getReferenceById(id);
      entity.setStatus(dto.getStatus());
      repository.save(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
