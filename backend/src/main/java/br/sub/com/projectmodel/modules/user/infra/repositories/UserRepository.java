package br.sub.com.projectmodel.modules.user.infra.repositories;

import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.projections.UserProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  /*
    SELECT email FROM tb_user
    WHERE id = 1 and CODE = 'f04f684a-797b-4d82-8805-c8887a4eface'
  */

  /*
    SELECT tb_user.first_name, tb_address.city, tb_address.street, tb_address.number, tb_address.district, tb_address.cep
    FROM tb_user
    INNER JOIN tb_user_address_association
    ON tb_user_address_association.user_id = tb_user.id
    INNER JOIN tb_address
    ON tb_user_address_association.user_id = tb_user.id
    WHERE tb_user_address_association.user_id = 1
    GROUP BY tb_user.first_name, tb_address.city, tb_address.street, tb_address.number, tb_address.district, tb_address.cep
  */
  User findByEmail(String email);


  @Query(nativeQuery = true, value = "SELECT email, code " +
    "FROM tb_user " +
    "WHERE id = :id and UPPER(code) = UPPER(:code)")
  Optional<UserProjections> userFindByEmail(Long id, String code);
}
