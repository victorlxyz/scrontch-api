package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.ContinentDto;

import java.util.List;

public interface ContinentService {
    List<ContinentDto> findAll();

    ContinentDto findById(Integer id);

    ContinentDto create(ContinentDto continentDto);

    ContinentDto update(Integer id, ContinentDto continentDto);

    void delete(Integer id);
}
