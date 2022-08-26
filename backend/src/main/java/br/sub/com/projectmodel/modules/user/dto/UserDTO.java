package br.sub.com.projectmodel.modules.user.dto;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import br.sub.com.projectmodel.modules.role.dto.RoleDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.constants.AppMessageConstants;
import br.sub.com.projectmodel.shared.enums.EnumStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  private Long id;
  private String code;
  @NotBlank(message = AppMessageConstants.REQUIRED_FIELD)
  private String firstName;
  private String lastName;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate birth;
  @Email(message = AppMessageConstants.REQUIRED_EMAIL)
  private String email;
  private EnumStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  private final Set<RoleDTO> roles = new HashSet<>();

  private final Set<AddressDTO> addresses = new HashSet<>();

  public UserDTO(){}

  public UserDTO(Long id, String code, String firstName, String lastName, LocalDate birth, String email,
                 EnumStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birth = birth;
    this.email = email;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public UserDTO(User entity){
    id = entity.getId();
    code = entity.getCode();
    firstName = entity.getFirstName();
    lastName = entity.getLastName();
    birth = entity.getBirth();
    email = entity.getEmail();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    entity.getAddresses().forEach(address -> this.addresses.add(new AddressDTO(address)));
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirth() {
    return birth;
  }

  public void setBirth(LocalDate birth) {
    this.birth = birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public Set<RoleDTO> getRoles() {
    return roles;
  }

  public Set<AddressDTO> getAddresses() {
    return addresses;
  }
}
