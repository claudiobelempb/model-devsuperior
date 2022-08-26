package br.sub.com.projectmodel.modules.user.usecase.UserUpdate;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.dto.UserUpdateDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.modules.user.mapper.UserUpdateMapper;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class UserUpdateService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserUpdateMapper mapper;

  @Transactional
  public UserDTO execute(Long id, UserUpdateDTO dto){
    try {
      User entity = repository.getReferenceById(id);
      mapper.userUpdateMapper(dto, entity);
      entity = repository.save(entity);
      return new UserDTO(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
