package xyz.victorl.scrontch.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.users.entity.EssentialIngredient;
import xyz.victorl.scrontch.users.entity.User;

import java.util.List;

public interface EssentialIngredientRepository extends JpaRepository<EssentialIngredient, Integer> {
    List<EssentialIngredient> findByUserid(User user);
}
