package br.sub.com.projectmodel.modules.user.dto;

import br.sub.com.projectmodel.modules.user.validation.UserUpdateValidator.UserUpdateValid;

import java.io.Serial;
import java.io.Serializable;

@UserUpdateValid
public class UserUpdateDTO extends UserDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

}
