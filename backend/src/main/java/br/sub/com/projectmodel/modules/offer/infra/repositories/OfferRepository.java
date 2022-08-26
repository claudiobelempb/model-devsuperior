package br.sub.com.projectmodel.modules.offer.infra.repositories;

import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
