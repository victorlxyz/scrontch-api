package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.RecipeDto;

import java.util.List;

public interface StepService {
    List<RecipeDto.StepDto> findAll();

    RecipeDto.StepDto findById(Integer id);

    RecipeDto.StepDto create(RecipeDto.StepDto stepDto);

    RecipeDto.StepDto update(Integer id, RecipeDto.StepDto stepDto);

    void delete(Integer id);
}
