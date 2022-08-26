package br.sub.com.projectmodel.modules.user.validation.UserCreateValidator;

import br.sub.com.projectmodel.modules.user.dto.UserCreateDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppMessageConstants;
import br.sub.com.projectmodel.shared.exeptions.resources.AppFieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserCreateValidator implements ConstraintValidator<UserCreateValid, UserCreateDTO> {
  @Autowired
  private UserRepository repository;

  @Override
  public void initialize(UserCreateValid ann) {
  }

  @Override
  public boolean isValid(UserCreateDTO dto, ConstraintValidatorContext context) {

    List<AppFieldMessage> erros = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User entity = repository.findByEmail(dto.getEmail());
    if(entity != null){
      erros.add(new AppFieldMessage("email", AppMessageConstants.REQUIRED_EMAIL_EXIST));
    }

    for (AppFieldMessage e : erros) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
        .addConstraintViolation();
    }
    return erros.isEmpty();
  }
}
