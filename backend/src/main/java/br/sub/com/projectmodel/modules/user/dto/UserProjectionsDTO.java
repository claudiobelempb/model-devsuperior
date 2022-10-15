package br.sub.com.projectmodel.modules.user.dto;

import br.sub.com.projectmodel.modules.user.projections.UserProjections;

public class UserProjectionsDTO {
  private String email;
  private String code;

  public UserProjectionsDTO(){}

  public UserProjectionsDTO(UserProjections entity){
    email = entity.getEmail();
    code = entity.getCode();
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "UserProjectionsDTO{" +
      "email='" + email + '\'' +
      ", code='" + code + '\'' +
      '}';
  }
}
