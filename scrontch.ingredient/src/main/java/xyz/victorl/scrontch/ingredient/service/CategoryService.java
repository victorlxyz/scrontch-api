package xyz.victorl.scrontch.ingredient.service;

import xyz.victorl.scrontch.ingredient.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(Integer id);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(Integer id, CategoryDto categoryDto);

    void delete(Integer id);
}
