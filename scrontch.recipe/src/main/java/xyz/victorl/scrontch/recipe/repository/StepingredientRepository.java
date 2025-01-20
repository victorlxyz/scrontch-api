package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Stepingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StepingredientRepository extends JpaRepository<Stepingredient, Integer> {

    @Query("SELECT si FROM Stepingredient si JOIN si.stepid s WHERE s.recipeid.id = :recipeId")
    List<Stepingredient> findByRecipeId(@Param("recipeId") Integer recipeId);
}
