package br.sub.com.projectmodel.modules.product.infra.repositories;

import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>,
  JpaSpecificationExecutor<ProductCategory> {

}
