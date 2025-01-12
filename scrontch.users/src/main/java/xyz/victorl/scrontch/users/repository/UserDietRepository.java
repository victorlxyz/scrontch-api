package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserDiet;

import java.util.List;

public interface UserDietRepository extends JpaRepository<UserDiet, Integer> {
    List<UserDiet> findByUserid(User user);
}
