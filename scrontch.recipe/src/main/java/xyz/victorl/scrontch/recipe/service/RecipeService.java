package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> findAll();

    RecipeDto findById(Integer id);

    RecipeDto create(RecipeDto recipeDto);

    RecipeDto update(Integer id, RecipeDto recipeDto);

    void delete(Integer id);
}
