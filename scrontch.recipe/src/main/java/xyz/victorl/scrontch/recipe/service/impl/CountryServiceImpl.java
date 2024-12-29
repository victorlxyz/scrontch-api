package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.CountryDto;
import xyz.victorl.scrontch.recipe.entity.Country;
import xyz.victorl.scrontch.recipe.mapper.CountryMapper;
import xyz.victorl.scrontch.recipe.repository.CountryRepository;
import xyz.victorl.scrontch.recipe.service.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    @Override
    public List<CountryDto> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CountryDto findById(Integer id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return countryMapper.toDto(country);
    }

    @Override
    public CountryDto create(CountryDto countryDto) {
        Country country = countryMapper.toEntity(countryDto);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public CountryDto update(Integer id, CountryDto countryDto) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        countryMapper.partialUpdate(countryDto, country);
        return countryMapper.toDto(countryRepository.save(country));
    }

    @Override
    public void delete(Integer id) {
        if (!countryRepository.existsById(id)) {
            throw new RuntimeException("Country not found");
        }
        countryRepository.deleteById(id);
    }
}
