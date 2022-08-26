package br.sub.com.projectmodel.modules.role.dto;

import br.sub.com.projectmodel.modules.role.infra.entities.Role;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class RoleDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String authority;
  private EnumStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  public RoleDTO(){}

  public RoleDTO(Long id, String code, String authority, EnumStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.authority = authority;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public RoleDTO(Role entity){
    id = entity.getId();
    code = entity.getCode();
    authority = entity.getAuthority();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

}
