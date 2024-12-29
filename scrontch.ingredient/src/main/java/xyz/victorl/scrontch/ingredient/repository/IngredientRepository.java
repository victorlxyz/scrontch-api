package xyz.victorl.scrontch.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findByNameContainingIgnoreCaseOrAliasContainingIgnoreCase(String name, String alias);
}
