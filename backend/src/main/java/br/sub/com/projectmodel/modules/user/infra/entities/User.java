package br.sub.com.projectmodel.modules.user.infra.entities;

import br.sub.com.projectmodel.modules.address.infra.entities.Address;
import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.modules.role.infra.entities.Role;
import br.sub.com.projectmodel.shared.enums.EnumStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails, Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String firstName;
  private String lastName;
  private LocalDate birth;
  @Column(unique = true)
  private String email;
  private String password;
  private EnumStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  /*Um course pode ter 0 ou mais offers uma para nuitos*/
  @OneToMany(mappedBy = "user")
  private final List<Notification> notifications = new ArrayList<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "tb_user_role_association",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private final Set<Role> roles = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
    name = "tb_user_address_association",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "address_id")
  )
  private final Set<Address> addresses = new HashSet<>();

  public User(){}

  public User(Long id, String code, String firstName, String lastName, LocalDate birth, String email, String password,
              EnumStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birth = birth;
    this.email = email;
    this.password = password;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
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

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles
      .stream()
      .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
      .collect(Collectors.toList());
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setPassword(String password) {
    this.password = password;
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

  public Set<Role> getRoles() {
    return roles;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public List<Notification> getNotifications() {
    return notifications;
  }

  @PrePersist
  public void prePersist(){
    code = String.valueOf(UUID.randomUUID());
    createdAt = Instant.now();
    status = EnumStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return id.equals(user.id) && code.equals(user.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, code);
  }

  public boolean hasRole(String roleName){
    for(Role role: roles){
      if(role.getAuthority().equals(roleName)){
        return true;
      }
    }
    return false;
  }
}
