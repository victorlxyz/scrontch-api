package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.StepingredientDto;

import java.util.List;

public interface StepingredientService {
    List<StepingredientDto> findAll();

    StepingredientDto findById(Integer id);

    StepingredientDto create(StepingredientDto stepingredientDto);

    StepingredientDto update(Integer id, StepingredientDto stepingredientDto);

    void delete(Integer id);
}
