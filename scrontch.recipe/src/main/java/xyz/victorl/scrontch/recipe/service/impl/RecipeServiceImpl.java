package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.entity.Recipe;
import xyz.victorl.scrontch.recipe.mapper.RecipeMapper;
import xyz.victorl.scrontch.recipe.repository.RecipeRepository;
import xyz.victorl.scrontch.recipe.service.RecipeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Override
    public List<RecipeDto> findAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto findById(Integer id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));
        return recipeMapper.toDto(recipe);
    }

    @Override
    public RecipeDto create(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.toEntity(recipeDto);
        return recipeMapper.toDto(recipeRepository.save(recipe));
    }

    @Override
    public RecipeDto update(Integer id, RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe not found"));

        recipeMapper.partialUpdate(recipeDto, recipe);
        return recipeMapper.toDto(recipeRepository.save(recipe));
    }

    @Override
    public void delete(Integer id) {
        if (!recipeRepository.existsById(id)) {
            throw new RuntimeException("Recipe not found");
        }
        recipeRepository.deleteById(id);
    }
}
