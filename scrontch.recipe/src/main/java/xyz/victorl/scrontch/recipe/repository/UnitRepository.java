package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
}
