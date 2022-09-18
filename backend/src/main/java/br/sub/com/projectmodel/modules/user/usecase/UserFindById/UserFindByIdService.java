package br.sub.com.projectmodel.modules.user.usecase.UserFindById;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.modules.user.usecase.UserAuthService.UserAuthService;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserFindByIdService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserAuthService userAuthService;

  @Transactional(readOnly = true)
  public UserDTO execute(Long id){
    /*04-23 Autorização customizada em nível de serviço*/
    userAuthService.validateSelfOrAdmin(id);

    Optional<User> obj = repository.findById(id);
    User entity = obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id));
    return new UserDTO(entity);
  }
}
