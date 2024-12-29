package xyz.victorl.scrontch.ingredient.service;

import xyz.victorl.scrontch.ingredient.dto.IngredientDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;

import java.util.List;

public interface IngredientService {
    List<IngredientDto> findAll();

    IngredientDto findById(Integer id);

    IngredientDto create(IngredientDto ingredientDto);

    IngredientDto update(Integer id, IngredientDto ingredientDto);

    void delete(Integer id);

    List<Ingredient> searchIngredients(String query);
}
