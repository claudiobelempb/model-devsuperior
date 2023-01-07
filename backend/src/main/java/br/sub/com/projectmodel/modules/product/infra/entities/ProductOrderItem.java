package br.sub.com.projectmodel.modules.product.infra.entities;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_product_order_item")
public class ProductOrderItem implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private Double total;
  private Integer quantity;

  @ManyToOne
  @JoinColumn(name = "product_order_id")
  private ProductOrder productOrder;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
  private EnumStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  public ProductOrderItem() {
  }

  public ProductOrderItem(Long id, String code, Double total, Integer quantity, ProductOrder productOrder,
   Product product,                       EnumStatus status,
                          Instant createdAt,
                          Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.total = total;
    this.quantity = quantity;
    this.productOrder = productOrder;
    this.product = product;
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductOrder getProductOrder() {
    return productOrder;
  }

  public void setProductOrder(ProductOrder productOrder) {
    this.productOrder = productOrder;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
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

    ProductOrderItem that = (ProductOrderItem) o;

    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
