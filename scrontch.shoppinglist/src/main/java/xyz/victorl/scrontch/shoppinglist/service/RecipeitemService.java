package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;

import java.util.List;

public interface RecipeitemService {
    List<RecipeitemDto> findAll();

    RecipeitemDto findById(Integer id);

    RecipeitemDto create(RecipeitemDto recipeitemDto);

    RecipeitemDto update(Integer id, RecipeitemDto recipeitemDto);

    void delete(Integer id);
}
