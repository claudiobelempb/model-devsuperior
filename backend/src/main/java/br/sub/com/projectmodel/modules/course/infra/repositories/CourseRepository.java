package br.sub.com.projectmodel.modules.course.infra.repositories;

import br.sub.com.projectmodel.modules.course.infra.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
