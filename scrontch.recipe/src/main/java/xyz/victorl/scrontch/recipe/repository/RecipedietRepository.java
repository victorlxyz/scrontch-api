package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Recipediet;

public interface RecipedietRepository extends JpaRepository<Recipediet, Integer> {
}
