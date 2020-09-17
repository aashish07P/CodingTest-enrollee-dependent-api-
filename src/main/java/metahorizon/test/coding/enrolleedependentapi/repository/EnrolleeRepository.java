package metahorizon.test.coding.enrolleedependentapi.repository;

import metahorizon.test.coding.enrolleedependentapi.entity.Enrollee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolleeRepository extends JpaRepository<Enrollee, Integer> {
}
