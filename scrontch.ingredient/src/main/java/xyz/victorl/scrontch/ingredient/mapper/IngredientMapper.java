package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {
    Ingredient toEntity(IngredientDto ingredientDto);

    IngredientDto toDto(Ingredient ingredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ingredient partialUpdate(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);
}