package xyz.victorl.scrontch.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import xyz.victorl.scrontch.ingredient.entity.Ingredientsubstitute;

public interface IngredientSubstituteRepository extends JpaRepository<Ingredientsubstitute, Integer> {

    List<Ingredientsubstitute> findByIdIngredientid(Integer ingredientId);

}
