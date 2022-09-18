package br.sub.com.projectmodel.modules.enrollment.infra.repositories;

import br.sub.com.projectmodel.modules.enrollment.infra.entities.Enrollment;
import br.sub.com.projectmodel.modules.enrollment.infra.entities.EnrollmentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentPK> {
}
