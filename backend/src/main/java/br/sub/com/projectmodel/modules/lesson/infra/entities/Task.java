package br.sub.com.projectmodel.modules.lesson.infra.entities;

import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private String description;
  private Integer questionCount;
  private Integer approvalCount;
  private Double weight;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant dueDate;


  public Task(){}

  public Task(Long id, String code, String title, Integer position, TypeStatus status, Instant createdAt,
              Instant updatedAt, Section section, String description, Integer questionCount, Integer approvalCount,
              Double weight, Instant dueDate) {
    super(id, code, title, position, status, createdAt, updatedAt, section);
    this.description = description;
    this.questionCount = questionCount;
    this.approvalCount = approvalCount;
    this.weight = weight;
    this.dueDate = dueDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getQuestionCount() {
    return questionCount;
  }

  public void setQuestionCount(Integer questionCount) {
    this.questionCount = questionCount;
  }

  public Integer getApprovalCount() {
    return approvalCount;
  }

  public void setApprovalCount(Integer approvalCoount) {
    this.approvalCount = approvalCoount;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Instant getDueDate() {
    return dueDate;
  }

  public void setDueDate(Instant dueDate) {
    this.dueDate = dueDate;
  }

}
