package xyz.victorl.scrontch.diet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.diet.entity.Diet;

public interface DietRepository extends JpaRepository<Diet, Integer> {
}
