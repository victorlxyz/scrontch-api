package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.common.dto.IngredientDto;
import xyz.victorl.scrontch.recipe.dto.PreparationmethodDto;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.dto.StepingredientDto;
import xyz.victorl.scrontch.recipe.dto.UnitDto;
import xyz.victorl.scrontch.recipe.entity.Recipe;
import xyz.victorl.scrontch.recipe.mapper.PreparationmethodMapper;
import xyz.victorl.scrontch.recipe.mapper.RecipeMapper;
import xyz.victorl.scrontch.recipe.mapper.UnitMapper;
import xyz.victorl.scrontch.recipe.repository.RecipeRepository;
import xyz.victorl.scrontch.recipe.service.IngredientService;
import xyz.victorl.scrontch.recipe.service.RecipeService;
import xyz.victorl.scrontch.recipe.entity.Stepingredient;
import xyz.victorl.scrontch.recipe.repository.StepingredientRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final StepingredientRepository stepingredientRepository;
    private final RecipeMapper recipeMapper;
    private final IngredientService ingredientService;
    private final UnitMapper unitMapper;
    private final PreparationmethodMapper preparationmethodMapper;

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

    @Override
    public List<StepingredientDto> getIngredientsForRecipe(Integer recipeId, Integer userId) {
        List<Stepingredient> stepIngredients = stepingredientRepository.findByRecipeId(recipeId);
        List<Integer> ingredientIds = stepIngredients.stream()
                .map(Stepingredient::getIngredientid)
                .toList();

        return stepIngredients.stream()
                .map(stepIngredient -> {
                    IngredientDto ingredientDto = null;
                    try {
                        ingredientDto = ingredientService.getIngredientById(stepIngredient.getIngredientid());
                    } catch (Exception e) {
                        System.out.println("Error fetching ingredient ID " + stepIngredient.getIngredientid() + ": " + e.getMessage());
                    }
                    UnitDto unitDto = unitMapper.toDto(stepIngredient.getUnitid());
                    PreparationmethodDto preparationmethodDto = preparationmethodMapper.toDto(stepIngredient.getPreparationid());

                    return new StepingredientDto(
                            stepIngredient.getId(),
                            stepIngredient.getIngredientid(),
                            stepIngredient.getQuantity(),
                            stepIngredient.getIsoptional(),
                            unitDto,
                            preparationmethodDto
                    );
                })
                .collect(Collectors.toList());
    }
}
