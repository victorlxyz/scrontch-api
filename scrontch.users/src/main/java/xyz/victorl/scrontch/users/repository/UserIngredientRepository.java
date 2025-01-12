package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserFavorite;
import xyz.victorl.scrontch.users.entity.UserIngredient;

import java.util.List;

public interface UserIngredientRepository extends JpaRepository<UserIngredient, Integer> {
    List<UserIngredient> findByUserid(User user);
}
