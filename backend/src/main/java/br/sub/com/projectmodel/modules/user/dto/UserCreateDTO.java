package br.sub.com.projectmodel.modules.user.dto;

import br.sub.com.projectmodel.modules.user.validation.UserCreateValidator.UserCreateValid;

import java.io.Serial;
import java.io.Serializable;

@UserCreateValid
public class UserCreateDTO extends UserDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private String password;

  UserCreateDTO(){
    super();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
