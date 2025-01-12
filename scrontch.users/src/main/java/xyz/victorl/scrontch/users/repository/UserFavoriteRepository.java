package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.UserFavorite;

public interface UserFavoriteRepository extends JpaRepository<UserFavorite, Integer> {
}
