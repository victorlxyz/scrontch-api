package xyz.victorl.scrontch.diet.service;

import xyz.victorl.scrontch.diet.dto.DietDto;

import java.util.List;

public interface DietService {
    List<DietDto> findAll();

    DietDto findById(Integer id);

    DietDto create(DietDto dietDto);

    DietDto update(Integer id, DietDto dietDto);

    void delete(Integer id);
}
