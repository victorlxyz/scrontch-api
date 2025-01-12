package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.UserIngredient;

public interface UserIngredientRepository extends JpaRepository<UserIngredient, Integer> {
}
