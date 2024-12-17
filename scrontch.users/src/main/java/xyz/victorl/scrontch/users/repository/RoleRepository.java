package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
