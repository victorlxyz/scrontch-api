package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.RecipelistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Recipelist;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RecipeitemMapper.class})
public interface RecipelistMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdat", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedat", expression = "java(java.time.Instant.now())")
    Recipelist toEntity(RecipelistDto recipelistDto);

    @AfterMapping
    default void linkRecipeitems(@MappingTarget Recipelist recipelist) {
        recipelist.getRecipeitems().forEach(recipeitem -> recipeitem.setRecipelistid(recipelist));
    }

    RecipelistDto toDto(Recipelist recipelist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    default Recipelist partialUpdate(RecipelistDto recipelistDto, @MappingTarget Recipelist recipelist) {
        if (recipelistDto.getId() != null) {
            recipelist.setId(recipelistDto.getId());
        }
        if (recipelistDto.getCreatedat() == null) {
            recipelist.setCreatedat(recipelist.getCreatedat());
        }
        return recipelist;
    }
}