package br.sub.com.projectmodel.modules.user.usecase.UserDetailsService;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
  private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User entity = repository.findByEmail(username);

    if(entity == null) {
      logger.error(AppExceptionConstants.EMAIL_NOT_FOUND + username);
      throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND);
    }
    logger.info(AppExceptionConstants.USER_FOUND + username);
    return entity;
  }
}
