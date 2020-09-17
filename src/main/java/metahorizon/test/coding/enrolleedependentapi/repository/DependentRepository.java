package metahorizon.test.coding.enrolleedependentapi.repository;

import metahorizon.test.coding.enrolleedependentapi.entity.Dependent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentRepository extends JpaRepository<Dependent, Integer> {
}
