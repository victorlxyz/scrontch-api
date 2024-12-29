package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Ingredientitem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientitemMapper {
    Ingredientitem toEntity(IngredientitemDto ingredientitemDto);

    IngredientitemDto toDto(Ingredientitem ingredientitem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Ingredientitem partialUpdate(IngredientitemDto ingredientitemDto, @MappingTarget Ingredientitem ingredientitem);
}