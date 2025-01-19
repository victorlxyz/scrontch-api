package xyz.victorl.scrontch.shoppinglist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.shoppinglist.entity.Recipeitem;

public interface RecipeitemRepository extends JpaRepository<Recipeitem, Integer> {
}
