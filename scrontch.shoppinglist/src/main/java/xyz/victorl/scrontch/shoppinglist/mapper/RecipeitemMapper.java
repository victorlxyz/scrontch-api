package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Recipeitem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeitemMapper {
    Recipeitem toEntity(RecipeitemDto recipeitemDto);

    RecipeitemDto toDto(Recipeitem recipeitem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipeitem partialUpdate(RecipeitemDto recipeitemDto, @MappingTarget Recipeitem recipeitem);
}