package br.sub.com.projectmodel.modules.user.usecase.UserDelete;

import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppDataBaseException;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteService {

  @Autowired
  private UserRepository repository;

  public void execute(Long id){
    try{
      repository.deleteById(id);
    }catch (EmptyResultDataAccessException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }catch (DataIntegrityViolationException e) {
      throw new AppDataBaseException(AppExceptionConstants.INTEGRITY_VIOLATION);
    }
  }
}
