package br.sub.com.projectmodel.modules.product.infra.repositories;

import br.sub.com.projectmodel.modules.product.dto.ProductNameProjectionDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.entities.ProductCategory;
import br.sub.com.projectmodel.modules.product.projections.ProductNameProjection;
import br.sub.com.projectmodel.shared.enums.EnumStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

  /*
    SELECT *
  FROM tb_product p
  INNER JOIN tb_product_category_association pcs
  ON p.id = pcs.product_id
  INNER JOIN tb_product_category pc
  ON pc.id = pcs.category_id
  WHERE  pcs.category_id = 2
  AND p.name LIKE '%Pizza%';

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

  /*JPQL filter product e categories*/
  /*"SELECT p Product p  WHERE :category = p.category" assim so funciona em relacionamento para um
    DISTINCT evita duplicação
  */
  String jpqlFilterProductCategory =
    "SELECT DISTINCT prod FROM Product prod " +
    "INNER JOIN prod.categories cats " +
    "WHERE (:productCategory IS NULL OR :productCategory IN cats) " +
    "AND (LOWER(prod.name) LIKE LOWER(CONCAT('%',:name,'%')))";
  @Query(jpqlFilterProductCategory)
  Page<Product> jpql(List<ProductCategory> productCategory, String name, Pageable pageable);

  String sqlFilterProductcategory =
    "SELECT * " +
    "FROM tb_product p " +
    "INNER JOIN tb_product_category_association pcs " +
    "ON p.id = pcs.product_id " +
    "INNER JOIN tb_product_category pc " +
    "ON pc.id = pcs.category_id " +
    "WHERE pcs.category_id = :productCategory " +
    "AND LOWER(p.name) LIKE LOWER(CONCAT('%',:name,'%'))";
  @Query(nativeQuery = true, value = sqlFilterProductcategory)
  Page<Product> sql(ProductCategory productCategory, String name, Pageable pageable);

  @Query("SELECT obj FROM Product obj JOIN FETCH obj.categories WHERE obj IN :products")
  void findProductsWithCategories(List<Product> products);

  @Query("SELECT obj FROM Product obj JOIN FETCH obj.images WHERE obj IN :products")
  void findProductsWithImages(List<Product> products);
  /*List product pelo nome*/

  String sqlFilterNameStatus = "SELECT name FROM tb_product WHERE status = :status";
  @Query(nativeQuery = true, value = sqlFilterNameStatus)
  List<ProductNameProjection> findByNameProduct(Integer status);

  String jpqlFilterNameStatus = "SELECT p.name " +
    "FROM Product p " + "WHERE p.status = :status";
  @Query(jpqlFilterNameStatus)
  List<ProductNameProjection> findByNameProduct1(Integer status);


  // Product findByName(String name);


  /*List product pelo status*/
  List<Product> findByStatus(EnumStatus status);
}
