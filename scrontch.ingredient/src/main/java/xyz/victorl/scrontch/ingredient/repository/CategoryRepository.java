package xyz.victorl.scrontch.ingredient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.ingredient.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
