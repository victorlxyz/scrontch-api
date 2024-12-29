package xyz.victorl.scrontch.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.recipe.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
