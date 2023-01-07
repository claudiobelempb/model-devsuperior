package br.sub.com.projectmodel.modules.product.infra.entities;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
@Entity
@Table(name = "tb_product_order")
public class ProductOrder implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private Double total;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  private EnumStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public ProductOrder(){}

  public ProductOrder(Long id, String code, Double total, User user, EnumStatus status, Instant createdAt,
                      Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.total = total;
    this.user = user;
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

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ProductOrder that = (ProductOrder) o;

    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
