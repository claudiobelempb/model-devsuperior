package br.sub.com.projectmodel.modules.notification.dto;

import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.shared.constants.AppMessageConstants;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class NotificationDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  @NotBlank(message = AppMessageConstants.REQUIRED_FIELD)
  private String code;
  @NotBlank(message = AppMessageConstants.REQUIRED_FIELD)
  private String text;
  private boolean read;
  @NotBlank(message = AppMessageConstants.REQUIRED_FIELD)
  private String route;
  private Instant createdAt;
  private Instant updatedAt;
  private EnumStatus status;
  private Long userId;

  public NotificationDTO(){}

  public NotificationDTO(Long id, String code, String text, boolean read, String route, Instant createdAt,
                         Instant updatedAt, EnumStatus status, Long userId) {
    this.id = id;
    this.code = code;
    this.text = text;
    this.read = read;
    this.route = route;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.status = status;
    this.userId = userId;
  }

  public NotificationDTO(Notification entity){
    id = entity.getId();
    code = entity.getCode();
    text = entity.getText();
    read = entity.isRead();
    route = entity.getRoute();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    userId = entity.getUser().getId();
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

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
