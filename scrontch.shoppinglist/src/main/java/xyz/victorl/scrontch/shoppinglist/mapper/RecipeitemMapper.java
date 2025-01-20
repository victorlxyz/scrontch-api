package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Recipeitem;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipeitemMapper {

    @Mapping(source = "recipelistid", target = "recipelistid.id")
    Recipeitem toEntity(RecipeitemDto recipeitemDto);

    @Mapping(source = "recipelistid.id", target = "recipelistid")
    RecipeitemDto toDto(Recipeitem recipeitem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "recipelistid", ignore = true)
    Recipeitem partialUpdate(RecipeitemDto recipeitemDto, @MappingTarget Recipeitem recipeitem);
}