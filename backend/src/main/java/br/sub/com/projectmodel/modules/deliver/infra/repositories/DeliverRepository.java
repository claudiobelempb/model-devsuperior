package br.sub.com.projectmodel.modules.deliver.infra.repositories;

import br.sub.com.projectmodel.modules.deliver.infra.entities.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverRepository extends JpaRepository<Deliver, Long> {
}
