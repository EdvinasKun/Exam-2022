package lt.vtmc.ExamVTMC.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lt.vtmc.ExamVTMC.models.ERole;
import lt.vtmc.ExamVTMC.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
