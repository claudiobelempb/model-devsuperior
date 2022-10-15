package br.sub.com.projectmodel.modules.seat.infra.repositories;

import br.sub.com.projectmodel.modules.seat.infra.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
