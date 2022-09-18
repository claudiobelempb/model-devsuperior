package br.sub.com.projectmodel.modules.user.usecase.UserAuthService;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppForbiddenException;
import br.sub.com.projectmodel.shared.exeptions.services.AppUnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthService {

  @Autowired
  private  UserRepository repository;

  @Transactional(readOnly = true)
  public User authenticated(){
    try{
      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      return repository.findByEmail(username);
    }catch (Exception e) {
      throw new AppUnauthorizedException(AppExceptionConstants.INVALID_USER);
    }
  }

  public void validateSelfOrAdmin(Long userId){
    User user = authenticated();
    if(!user.getId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
      throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
    }
  }

}
