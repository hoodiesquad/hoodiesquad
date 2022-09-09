package site.hoodiesquad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import site.hoodiesquad.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}