package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;

import java.util.List;

public interface IngredientitemService {
    List<IngredientitemDto> findAll();

    IngredientitemDto findById(Integer id);

    IngredientitemDto create(IngredientitemDto ingredientitemDto);

    IngredientitemDto update(Integer id, IngredientitemDto ingredientitemDto);

    void delete(Integer id);
}
