package xyz.victorl.scrontch.ingredient.service;

import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;

import java.util.List;

public interface IngredientSubstituteService {
    List<IngredientSubstituteDto> findAll();

    IngredientSubstituteDto findById(Integer id);

    IngredientSubstituteDto create(IngredientSubstituteDto ingredientSubstituteDto);

    IngredientSubstituteDto update(Integer id, IngredientSubstituteDto ingredientSubstituteDto);

    void delete(Integer id);
}
