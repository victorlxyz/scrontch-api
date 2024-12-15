package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;
import xyz.victorl.scrontch.ingredient.entity.Ingredientsubstitute;
import xyz.victorl.scrontch.ingredient.entity.IngredientsubstituteId;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientSubstituteMapper {

    // Map from Entity to DTO
    @Mapping(source = "id.ingredientid", target = "ingredientId")
    @Mapping(source = "id.substituteingredientid", target = "substituteIngredientId")
    IngredientSubstituteDto toDto(Ingredientsubstitute ingredientsubstitute);

    // Map from DTO to Entity
    @Mapping(source = "ingredientId", target = "id.ingredientid")
    @Mapping(source = "substituteIngredientId", target = "id.substituteingredientid")
    Ingredientsubstitute toEntity(IngredientSubstituteDto ingredientSubstituteDto);

    // Update existing entity with new DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "ingredientId", target = "id.ingredientid")
    @Mapping(source = "substituteIngredientId", target = "id.substituteingredientid")
    Ingredientsubstitute partialUpdate(IngredientSubstituteDto ingredientSubstituteDto, @MappingTarget Ingredientsubstitute ingredientsubstitute);
}
