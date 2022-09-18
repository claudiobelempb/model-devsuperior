package br.sub.com.projectmodel.modules.deliver.dto;



import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import br.sub.com.projectmodel.shared.enums.TypeDeliver;

import java.io.Serial;
import java.io.Serializable;

public class DeliverRevisionUpdateDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String feedback;
  private Integer correctCount;
  private TypeDeliver status;

  public DeliverRevisionUpdateDTO(){}

  public DeliverRevisionUpdateDTO(Long id, String code, String feedback, Integer correctCount, TypeDeliver status) {
    this.id = id;
    this.code = code;
    this.feedback = feedback;
    this.correctCount = correctCount;
    this.status = status;
  }

  public DeliverRevisionUpdateDTO(Deliver entity){
    id = entity.getId();
    code = entity.getCode();
    feedback = entity.getFeedback();
    status = entity.getStatus();
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

}
