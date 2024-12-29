package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.TypeDto;

import java.util.List;

public interface TypeService {
    List<TypeDto> findAll();

    TypeDto findById(Integer id);

    TypeDto create(TypeDto typeDto);

    TypeDto update(Integer id, TypeDto typeDto);

    void delete(Integer id);
}
