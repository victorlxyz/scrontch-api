package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Stepingredient;

public interface StepingredientRepository extends JpaRepository<Stepingredient, Integer> {
}
