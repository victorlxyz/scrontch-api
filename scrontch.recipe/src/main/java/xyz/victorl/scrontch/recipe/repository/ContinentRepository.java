package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {
}
