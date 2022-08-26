package br.sub.com.projectmodel.modules.resource.infra.repositories;

import br.sub.com.projectmodel.modules.resource.infra.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
