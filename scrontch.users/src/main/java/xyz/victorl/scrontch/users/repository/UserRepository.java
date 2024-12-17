package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
