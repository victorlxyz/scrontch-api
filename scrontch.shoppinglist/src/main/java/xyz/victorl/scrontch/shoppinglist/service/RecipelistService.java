package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.RecipelistDto;

import java.util.List;

public interface RecipelistService {
    List<RecipelistDto> findAll();

    RecipelistDto findById(Integer id);

    RecipelistDto create(RecipelistDto recipelistDto);

    RecipelistDto update(Integer id, RecipelistDto recipelistDto);

    void delete(Integer id);

    List<RecipelistDto> findByUserId(Integer userid);

    RecipeitemDto addRecipeItemToRecipelist(Integer recipelistId, RecipeitemDto recipeitemDto);
}
