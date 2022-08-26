package br.sub.com.projectmodel.modules.notification.infra.entities;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_notification")
public class Notification implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String code;

  private String text;
  private boolean read;
  private String route;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;
  private EnumStatus status;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Notification(Long id, String code, String text, boolean read, String route, Instant createdAt,
                      Instant updatedAt,
                      EnumStatus status, User user) {
    this.id = id;
    this.code = code;
    this.text = text;
    this.read = read;
    this.route = route;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.user = user;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  public String getRoute() {
    return route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }


  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @PrePersist
  public void prePersist(){
    code = UUID.randomUUID().toString();
    read = false;
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
    Notification that = (Notification) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
