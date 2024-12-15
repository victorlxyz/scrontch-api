package xyz.victorl.scrontch.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
