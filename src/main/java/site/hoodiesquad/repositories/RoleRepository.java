package site.hoodiesquad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.hoodiesquad.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}