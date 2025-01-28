package xyz.victorl.scrontch.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.common.entity.Ingredientitem;

public interface IngredientitemRepository extends JpaRepository<Ingredientitem, Integer> {
}
