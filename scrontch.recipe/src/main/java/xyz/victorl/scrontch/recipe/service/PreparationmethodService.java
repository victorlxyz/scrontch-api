package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.PreparationmethodDto;

import java.util.List;

public interface PreparationmethodService {
    List<PreparationmethodDto> findAll();

    PreparationmethodDto findById(Integer id);

    PreparationmethodDto create(PreparationmethodDto preparationmethodDto);

    PreparationmethodDto update(Integer id, PreparationmethodDto preparationmethodDto);

    void delete(Integer id);
}
