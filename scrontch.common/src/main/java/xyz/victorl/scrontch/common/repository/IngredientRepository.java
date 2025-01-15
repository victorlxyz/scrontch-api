package xyz.victorl.scrontch.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.common.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByNameContainingIgnoreCaseOrAliasContainingIgnoreCase(String name, String alias);
}
