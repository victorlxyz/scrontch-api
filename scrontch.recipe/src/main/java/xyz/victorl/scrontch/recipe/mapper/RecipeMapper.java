package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.entity.Recipe;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TypeMapper.class, CountryMapper.class, RecipedietMapper.class, StepMapper.class})
public interface RecipeMapper {
    Recipe toEntity(RecipeDto recipeDto);

    @AfterMapping
    default void linkRecipediets(@MappingTarget Recipe recipe) {
        recipe.getRecipediets().forEach(recipediet -> recipediet.setRecipeid(recipe));
    }

    @AfterMapping
    default void linkSteps(@MappingTarget Recipe recipe) {
        recipe.getSteps().forEach(step -> step.setRecipeid(recipe));
    }

    RecipeDto toDto(Recipe recipe);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipe partialUpdate(RecipeDto recipeDto, @MappingTarget Recipe recipe);
}