package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.dto.StepingredientDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAll();

    RecipeDto findById(Integer id);

    RecipeDto create(RecipeDto recipeDto);

    RecipeDto update(Integer id, RecipeDto recipeDto);

    void delete(Integer id);

    List<StepingredientDto> getIngredientsForRecipe(Integer recipeId, Integer userId);


}
