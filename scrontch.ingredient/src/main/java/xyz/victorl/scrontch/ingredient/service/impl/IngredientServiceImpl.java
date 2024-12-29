package xyz.victorl.scrontch.ingredient.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;
import xyz.victorl.scrontch.ingredient.mapper.IngredientMapper;
import xyz.victorl.scrontch.ingredient.repository.IngredientRepository;
import xyz.victorl.scrontch.ingredient.service.IngredientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;
    private final IngredientMapper ingredientMapper;

    @Override
    public List<IngredientDto> findAll() {
        return ingredientRepository.findAll()
                .stream()
                .map(ingredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDto findById(Integer id) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    public IngredientDto create(IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientMapper.toEntity(ingredientDto);
        ingredient = ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    public IngredientDto update(Integer id, IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));

        ingredientMapper.partialUpdate(ingredientDto, ingredient);
        ingredient = ingredientRepository.save(ingredient);
        return ingredientMapper.toDto(ingredient);
    }

    @Override
    public void delete(Integer id) {
        if (!ingredientRepository.existsById(id)) {
            throw new RuntimeException("Ingredient not found");
        }
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<Ingredient> searchIngredients(String query) {
        return ingredientRepository.findByNameContainingIgnoreCaseOrAliasContainingIgnoreCase(query, query);
    }
}
