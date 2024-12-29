package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.PreparationmethodDto;
import xyz.victorl.scrontch.recipe.entity.Preparationmethod;
import xyz.victorl.scrontch.recipe.mapper.PreparationmethodMapper;
import xyz.victorl.scrontch.recipe.repository.PreparationmethodRepository;
import xyz.victorl.scrontch.recipe.service.PreparationmethodService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PreparationmethodServiceImpl implements PreparationmethodService {

    private final PreparationmethodRepository preparationmethodRepository;
    private final PreparationmethodMapper preparationmethodMapper;

    @Override
    public List<PreparationmethodDto> findAll() {
        return preparationmethodRepository.findAll()
                .stream()
                .map(preparationmethodMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PreparationmethodDto findById(Integer id) {
        Preparationmethod preparationmethod = preparationmethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preparationmethod not found"));
        return preparationmethodMapper.toDto(preparationmethod);
    }

    @Override
    public PreparationmethodDto create(PreparationmethodDto preparationmethodDto) {
        Preparationmethod preparationmethod = preparationmethodMapper.toEntity(preparationmethodDto);
        return preparationmethodMapper.toDto(preparationmethodRepository.save(preparationmethod));
    }

    @Override
    public PreparationmethodDto update(Integer id, PreparationmethodDto preparationmethodDto) {
        Preparationmethod preparationmethod = preparationmethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Preparationmethod not found"));

        preparationmethodMapper.partialUpdate(preparationmethodDto, preparationmethod);
        return preparationmethodMapper.toDto(preparationmethodRepository.save(preparationmethod));
    }

    @Override
    public void delete(Integer id) {
        if (!preparationmethodRepository.existsById(id)) {
            throw new RuntimeException("Preparationmethod not found");
        }
        preparationmethodRepository.deleteById(id);
    }
}
