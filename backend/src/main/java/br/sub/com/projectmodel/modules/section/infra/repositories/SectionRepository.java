package br.sub.com.projectmodel.modules.section.infra.repositories;

import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {
}
