package br.sub.com.projectmodel.modules.product.specification.ProductSpecification;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {

  public Specification<Product> execute(ProductDTO dto) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if(!ObjectUtils.isEmpty(dto.getName())){
        predicates.add(
          criteriaBuilder.like(
            criteriaBuilder.upper(root.get("name")), dto.getName().toUpperCase().concat("%")
          )
        );
      }

      if(!ObjectUtils.isEmpty(dto.getStatus())){
        predicates.add(
          criteriaBuilder.equal(root.get("status"), dto.getStatus())
        );
      }


      if(!ObjectUtils.isEmpty(dto.getCreatedAt())){
        predicates.add(
          /*Maior ou Igual*/
          criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), dto.getCreatedAt())
        );
      }

      if(!ObjectUtils.isEmpty(dto.getUpdatedAt())){
        predicates.add(
          /*Menor ou Igual*/
          criteriaBuilder.lessThanOrEqualTo(root.get("updatedAt"), dto.getUpdatedAt())
        );
      }

      if(!ObjectUtils.isEmpty(dto.getCategories())){
        Join<ProductCategory, Product> join = root.join("categories");
        predicates.add(
          /*Menor ou Igual*/

          criteriaBuilder.equal(join.get("id"), join)
        );
      }

      return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
    };
  }

  public static Specification<Product> hasCategoryWith(Long categoryId) {
    return (root, query, criteriaBuilder) -> {
      Join<ProductCategory, Product> products = root.join("getCategories");
      return criteriaBuilder.equal(products.get("id"), categoryId);
    };
  }
}
