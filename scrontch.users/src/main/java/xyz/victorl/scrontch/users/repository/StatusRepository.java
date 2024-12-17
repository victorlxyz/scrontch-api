package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
