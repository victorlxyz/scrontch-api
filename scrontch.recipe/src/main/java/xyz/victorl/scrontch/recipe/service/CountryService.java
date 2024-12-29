package xyz.victorl.scrontch.recipe.service;

import xyz.victorl.scrontch.recipe.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> findAll();

    CountryDto findById(Integer id);

    CountryDto create(CountryDto countryDto);

    CountryDto update(Integer id, CountryDto countryDto);

    void delete(Integer id);
}
