package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserFavorite;

import java.util.List;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer> {
    List<UserFavorite> findByUserid(User user);
}
