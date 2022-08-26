package br.sub.com.projectmodel.modules.role.infra.repositories;

import br.sub.com.projectmodel.modules.role.infra.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
