package br.sub.com.projectmodel.modules.product.specification.ProductCategorySpecification;

import br.sub.com.projectmodel.modules.product.filter.ProductCategoryFilter;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductCategorySpecification {

  public ProductCategorySpecification(){}

  public Specification<ProductCategory> products(ProductCategoryFilter filter) {
    return (root, query, criteriaBuilder) -> {
      List<Predicate> predicateList = new ArrayList<>();

      if (!ObjectUtils.isEmpty(filter.getName())) {
        predicateList.add(
          criteriaBuilder.like(
            criteriaBuilder.upper(root.get("name")), filter.getName().toUpperCase().concat("%")
          )
        );
      }

      if (!ObjectUtils.isEmpty(filter.getStatus())) {
        predicateList.add(
          criteriaBuilder.equal(root.get("status"), filter.getStatus())
        );
      }

      if (!ObjectUtils.isEmpty(filter.getCreatedAt())) {
        predicateList.add(
          criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), filter.getCreatedAt())
        );
      }

      if (!ObjectUtils.isEmpty(filter.getUpdatedAt())) {
        predicateList.add(
          criteriaBuilder.lessThanOrEqualTo(root.get("updatedAt"), filter.getUpdatedAt())
        );
      }

      if (!ObjectUtils.isEmpty(filter.getUpdatedAt())) {
        Predicate date =  criteriaBuilder.between(root.get("date"), filter.getCreatedAt(), filter.getUpdatedAt());
        predicateList.add(date);
      }

      return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
    };
  }
}
