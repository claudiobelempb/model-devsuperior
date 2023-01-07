package br.sub.com.projectmodel.modules.user.validation.UserUpdateValidator;

import br.sub.com.projectmodel.modules.user.dto.UserUpdateDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.shared.constants.AppMessageConstants;
import br.sub.com.projectmodel.shared.exeptions.resources.AppFieldMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

public class UserUpdateValidator
  implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private UserRepository repository;

  @Override
  public void initialize(UserUpdateValid ann) {}

  @Override
  public boolean isValid(
    UserUpdateDTO dto,
    ConstraintValidatorContext context
  ) {
    var uriVars = (Map<String, String>) request.getAttribute(
      HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE
    );
    long userId = Long.parseLong(uriVars.get("id"));

    List<AppFieldMessage> erros = new ArrayList<>();

    // Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
    User entity = repository.findByEmail(dto.getEmail());
    if (entity != null && userId != entity.getId()) {
      erros.add(
        new AppFieldMessage("email", AppMessageConstants.REQUIRED_EMAIL_EXIST)
      );
    }

    for (AppFieldMessage e : erros) {
      context.disableDefaultConstraintViolation();
      context
        .buildConstraintViolationWithTemplate(e.getMessage())
        .addPropertyNode(e.getFieldName())
        .addConstraintViolation();
    }
    return erros.isEmpty();
  }
}
