package br.sub.com.projectmodel.modules.client.infra.repositories;

import br.sub.com.projectmodel.modules.client.infra.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
