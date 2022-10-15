package br.sub.com.projectmodel.modules.product.infra.repositories;

import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

  /*
    -- SELECT * FROM tb_product
    SELECT * FROM tb_product p
    LEFT JOIN tb_product_category_association AS tcs
    ON tcs.product_id = p.id
    LEFT JOIN tb_product_category as c
    ON tcs.category_id = c.id
    WHERE p.id = 7
  */

  /*
    Funciona Em Relacioamentos de Um para Um
    @Query("SELECT obj FROM Product obj " +
    "WHERE :category = obj.category")*/
  @Query("SELECT DISTINCT obj FROM Product obj " +
    "INNER JOIN obj.categories cats " +
    "WHERE (:categories IS NULL OR cats IN :categories) " +
    "AND (LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) )")
  Page<Product> search(List<ProductCategory> categories, String name, Pageable pageable);

  @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
  void findProductsWithCategories(List<Product> products);

  @Query("SELECT obj FROM Product obj JOIN FETCH obj.images WHERE obj IN :products")
  void findProductsWithImages(List<Product> products);
}
