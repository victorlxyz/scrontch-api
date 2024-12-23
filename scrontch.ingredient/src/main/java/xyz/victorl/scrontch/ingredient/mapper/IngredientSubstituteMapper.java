package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;
import xyz.victorl.scrontch.ingredient.entity.Ingredientsubstitute;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientSubstituteMapper {

    // Existing mappings
    @Mapping(source = "id.ingredientid", target = "ingredientId")
    @Mapping(source = "id.substituteingredientid", target = "substituteingredientid")
    IngredientSubstituteDto toDto(Ingredientsubstitute ingredientsubstitute);

    @Mapping(source = "ingredientId", target = "id.ingredientid")
    @Mapping(source = "substituteingredientid", target = "id.substituteingredientid")
    Ingredientsubstitute toEntity(IngredientSubstituteDto ingredientSubstituteDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "ingredientId", target = "id.ingredientid")
    @Mapping(source = "substituteingredientid", target = "id.substituteingredientid")
    Ingredientsubstitute partialUpdate(IngredientSubstituteDto ingredientSubstituteDto, @MappingTarget Ingredientsubstitute ingredientsubstitute);

    // Add this custom method to map Integer to Ingredient
    default Ingredient map(Integer id) {
        if (id == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        return ingredient;
    }
}

