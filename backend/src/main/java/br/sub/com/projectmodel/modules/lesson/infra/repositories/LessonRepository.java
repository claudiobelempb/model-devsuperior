package br.sub.com.projectmodel.modules.lesson.infra.repositories;

import br.sub.com.projectmodel.modules.lesson.infra.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
