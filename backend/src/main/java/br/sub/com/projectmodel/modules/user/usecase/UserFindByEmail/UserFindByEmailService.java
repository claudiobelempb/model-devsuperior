package br.sub.com.projectmodel.modules.user.usecase.UserFindByEmail;

import br.sub.com.projectmodel.modules.user.dto.UserProjectionsDTO;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.modules.user.projections.UserProjections;
import br.sub.com.projectmodel.modules.user.usecase.UserAuthService.UserAuthService;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserFindByEmailService {

  @Autowired
  private UserRepository repository;

  @Autowired
  private UserAuthService userAuthService;

  @Transactional(readOnly = true)
  public UserProjectionsDTO execute(Long id, String code){
    /*04-23 Autorização customizada em nível de serviço*/
    userAuthService.validateSelfOrAdmin(id);

    Optional<UserProjections> obj = repository.userFindByEmail(id, code);
    UserProjections entity = obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id));
    return new UserProjectionsDTO(entity);
  }

}
