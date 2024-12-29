package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
