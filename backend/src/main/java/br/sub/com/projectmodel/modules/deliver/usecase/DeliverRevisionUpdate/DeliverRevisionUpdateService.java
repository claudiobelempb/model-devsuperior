package br.sub.com.projectmodel.modules.deliver.usecase.DeliverRevisionUpdate;

import br.sub.com.projectmodel.modules.deliver.dto.DeliverRevisionUpdateDTO;
import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import br.sub.com.projectmodel.modules.deliver.infra.repositories.DeliverRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class DeliverRevisionUpdateService {

  @Autowired
  private DeliverRepository repository;

  /*04-26 Pré-autorizando métodos por perfil de usuário*/
  /* @Transactional
  public DeliverRevisionUpdateDTO execute(Long id, DeliverRevisionUpdateDTO dto){
    try {
      Deliver entity = repository.getReferenceById(id);

      entity.setFeedback(dto.getFeedback());
      entity.setCorrectCount(dto.getCorrectCount());
      entity.setStatus(dto.getStatus());
      entity = repository.save(entity);
      return new DeliverRevisionUpdateDTO(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }*/

  /*04-26 Pré-autorizando métodos por perfil de usuário*/
  @PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
  @Transactional
  public void execute(Long id, DeliverRevisionUpdateDTO dto){
    try {
      Deliver entity = repository.getReferenceById(id);

      entity.setFeedback(dto.getFeedback());
      entity.setCorrectCount(dto.getCorrectCount());
      entity.setStatus(dto.getStatus());
      repository.save(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + id);
    }
  }
}
