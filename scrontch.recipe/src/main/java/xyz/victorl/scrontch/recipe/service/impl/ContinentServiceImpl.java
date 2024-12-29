package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.ContinentDto;
import xyz.victorl.scrontch.recipe.entity.Continent;
import xyz.victorl.scrontch.recipe.mapper.ContinentMapper;
import xyz.victorl.scrontch.recipe.repository.ContinentRepository;
import xyz.victorl.scrontch.recipe.service.ContinentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ContinentServiceImpl implements ContinentService {

    private final ContinentRepository continentRepository;
    private final ContinentMapper continentMapper;

    @Override
    public List<ContinentDto> findAll() {
        return continentRepository.findAll()
                .stream()
                .map(continentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContinentDto findById(Integer id) {
        Continent continent = continentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Continent not found"));
        return continentMapper.toDto(continent);
    }

    @Override
    public ContinentDto create(ContinentDto continentDto) {
        Continent continent = continentMapper.toEntity(continentDto);
        return continentMapper.toDto(continentRepository.save(continent));
    }

    @Override
    public ContinentDto update(Integer id, ContinentDto continentDto) {
        Continent continent = continentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Continent not found"));

        continentMapper.partialUpdate(continentDto, continent);
        return continentMapper.toDto(continentRepository.save(continent));
    }

    @Override
    public void delete(Integer id) {
        if (!continentRepository.existsById(id)) {
            throw new RuntimeException("Continent not found");
        }
        continentRepository.deleteById(id);
    }
}
