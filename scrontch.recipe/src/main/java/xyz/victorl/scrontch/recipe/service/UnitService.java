package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.UnitDto;

import java.util.List;

public interface UnitService {
    List<UnitDto> findAll();

    UnitDto findById(Integer id);

    UnitDto create(UnitDto unitDto);

    UnitDto update(Integer id, UnitDto unitDto);

    void delete(Integer id);
}
