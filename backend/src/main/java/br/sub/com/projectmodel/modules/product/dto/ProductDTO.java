package br.sub.com.projectmodel.modules.product.dto;

import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductImage;
import br.sub.com.projectmodel.shared.constants.AppMessageConstants;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  @Size(min = 5, max = 60, message = AppMessageConstants.REQUIRED_SIZE_MESSAGE)
  @NotBlank(message = AppMessageConstants.REQUIRED_FIELD)
  private String name;
  @Positive(message = AppMessageConstants.REQUIRED_PRICE_POSITIVO)
  private Double price;
  private String description;
  private EnumStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  private final List<ProductImageDTO> images = new ArrayList<>();
  private final List<ProductCategoryDTO> categories = new ArrayList<>();

  public ProductDTO(){}

  public ProductDTO(Long id, String name, String code, Double price, String description,
                    EnumStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.price = price;
    this.description = description;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public ProductDTO(Product entity){
    this.id = entity.getId();
    this.code = entity.getCode();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.price = entity.getPrice();
    this.status = entity.getStatus();
    this.createdAt = entity.getCreatedAt();
    this.updatedAt = entity.getUpdatedAt();
  }

  public ProductDTO(Product entity, Set<ProductCategory> categories, Set<ProductImage> images){
    this(entity);
    categories.forEach(category -> this.categories.add(new ProductCategoryDTO(category)));
    images.forEach(image -> this.images.add(new ProductImageDTO(image)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public List<ProductCategoryDTO> getCategories() {
    return categories;
  }
  public List<ProductImageDTO> getImages() {
    return images;
  }

}
