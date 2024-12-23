package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;
import xyz.victorl.scrontch.ingredient.entity.Ingredientsubstitute;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {

    @Mapping(source = "categoryid.id", target = "categoryid")
    IngredientDto toDto(Ingredient ingredient);

    @Mapping(source = "categoryid", target = "categoryid.id")
    Ingredient toEntity(IngredientDto ingredientDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "categoryid", target = "categoryid.id")
    Ingredient partialUpdate(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);

    // Add this method to map IngredientSubstitute entity to DTO
    @Mapping(source = "id.ingredientid", target = "ingredientId")
    @Mapping(source = "id.substituteingredientid", target = "substituteingredientid")
    IngredientSubstituteDto toSubstituteDto(Ingredientsubstitute ingredientsubstitute);

    // Add this custom method to map Integer to Ingredient (already in your original mapper)
    default Ingredient map(Integer id) {
        if (id == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        return ingredient;
    }
}
