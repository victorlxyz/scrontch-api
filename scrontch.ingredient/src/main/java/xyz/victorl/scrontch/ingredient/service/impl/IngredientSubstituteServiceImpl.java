package xyz.victorl.scrontch.ingredient.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredientsubstitute;
import xyz.victorl.scrontch.ingredient.mapper.IngredientSubstituteMapper;
import xyz.victorl.scrontch.ingredient.repository.IngredientSubstituteRepository;
import xyz.victorl.scrontch.ingredient.service.IngredientSubstituteService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientSubstituteServiceImpl implements IngredientSubstituteService {

    private final IngredientSubstituteRepository ingredientSubstituteRepository;
    private final IngredientSubstituteMapper ingredientSubstituteMapper;

    @Override
    public List<IngredientSubstituteDto> findAll() {
        return ingredientSubstituteRepository.findAll()
                .stream()
                .map(ingredientSubstituteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientSubstituteDto findById(Integer id) {
        Ingredientsubstitute ingredientSubstitute = ingredientSubstituteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IngredientSubstitute not found"));
        return ingredientSubstituteMapper.toDto(ingredientSubstitute);
    }

    @Override
    public IngredientSubstituteDto create(IngredientSubstituteDto ingredientSubstituteDto) {
        Ingredientsubstitute ingredientSubstitute = ingredientSubstituteMapper.toEntity(ingredientSubstituteDto);
        return ingredientSubstituteMapper.toDto(ingredientSubstituteRepository.save(ingredientSubstitute));
    }

    @Override
    public IngredientSubstituteDto update(Integer id, IngredientSubstituteDto ingredientSubstituteDto) {
        Ingredientsubstitute ingredientSubstitute = ingredientSubstituteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("IngredientSubstitute not found"));

        ingredientSubstituteMapper.partialUpdate(ingredientSubstituteDto, ingredientSubstitute);
        return ingredientSubstituteMapper.toDto(ingredientSubstituteRepository.save(ingredientSubstitute));
    }

    @Override
    public void delete(Integer id) {
        if (!ingredientSubstituteRepository.existsById(id)) {
            throw new RuntimeException("IngredientSubstitute not found");
        }
        ingredientSubstituteRepository.deleteById(id);
    }
}
