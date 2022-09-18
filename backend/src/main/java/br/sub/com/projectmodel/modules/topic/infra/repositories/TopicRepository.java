package br.sub.com.projectmodel.modules.topic.infra.repositories;

import br.sub.com.projectmodel.modules.topic.infra.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
