package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.RecipedietDto;

import java.util.List;

public interface RecipedietService {
    List<RecipedietDto> findAll();

    RecipedietDto findById(Integer id);

    RecipedietDto create(RecipedietDto recipedietDto);

    RecipedietDto update(Integer id, RecipedietDto recipedietDto);

    void delete(Integer id);
}
