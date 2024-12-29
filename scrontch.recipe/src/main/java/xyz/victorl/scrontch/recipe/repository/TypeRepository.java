package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {
}
