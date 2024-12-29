package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientMapper {

    @Mapping(source = "categoryid.id", target = "categoryid")
    @Mapping(source = "alias", target = "alias")
    IngredientDto toDto(Ingredient ingredient);

    @Mapping(source = "categoryid", target = "categoryid.id")
    @Mapping(source = "alias", target = "alias")
    Ingredient toEntity(IngredientDto ingredientDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "categoryid", target = "categoryid.id")
    @Mapping(source = "alias", target = "alias")
    Ingredient partialUpdate(IngredientDto ingredientDto, @MappingTarget Ingredient ingredient);

    default Ingredient map(Integer id) {
        if (id == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(id);
        return ingredient;
    }
}
