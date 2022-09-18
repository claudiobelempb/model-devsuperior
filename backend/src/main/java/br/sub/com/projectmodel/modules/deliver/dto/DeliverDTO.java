package br.sub.com.projectmodel.modules.deliver.dto;

import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import br.sub.com.projectmodel.shared.enums.TypeDeliver;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class DeliverDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String url;
  private String feedback;
  private Integer correctCount;
  private TypeDeliver status;
  private Instant createdAt;
  private Instant updatedAt;

  public DeliverDTO(){}

  public DeliverDTO(Long id, String code, String url, String feedback, Integer correctCount, TypeDeliver status,
                    Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.url = url;
    this.feedback = feedback;
    this.correctCount = correctCount;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public DeliverDTO(Deliver entity){
    id = entity.getId();
    code = entity.getCode();
    url = entity.getUrl();
    feedback = entity.getFeedback();
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public Integer getCorrectCount() {
    return correctCount;
  }

  public void setCorrectCount(Integer correctCount) {
    this.correctCount = correctCount;
  }

  public TypeDeliver getStatus() {
    return status;
  }

  public void setStatus(TypeDeliver status) {
    this.status = status;
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
}
