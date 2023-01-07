package br.sub.com.projectmodel.modules.product.infra.repositories;

import br.sub.com.projectmodel.modules.product.infra.entities.ProductOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderItemRepository extends JpaRepository<ProductOrderItem, Long> {
}
