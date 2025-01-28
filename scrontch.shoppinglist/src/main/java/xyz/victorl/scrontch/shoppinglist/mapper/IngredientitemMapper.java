package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.common.entity.Ingredientitem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface IngredientitemMapper {

    @Mapping(source = "shoppinglistid", target = "shoppinglistid.id")
    Ingredientitem toEntity(IngredientitemDto ingredientitemDto);


    @Mapping(source = "shoppinglistid.id", target = "shoppinglistid")
    IngredientitemDto toDto(Ingredientitem ingredientitem);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "shoppinglistid", ignore = true)
    Ingredientitem partialUpdate(IngredientitemDto ingredientitemDto, @MappingTarget Ingredientitem ingredientitem);

}
