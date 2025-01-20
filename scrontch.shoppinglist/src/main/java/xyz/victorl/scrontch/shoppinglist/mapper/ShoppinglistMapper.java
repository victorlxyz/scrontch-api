package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientitemMapper.class, NonfooditemMapper.class})
public interface ShoppinglistMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdat", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedat", expression = "java(java.time.Instant.now())")
    Shoppinglist toEntity(ShoppinglistDto shoppinglistDto);

    ShoppinglistDto toDto(Shoppinglist shoppinglist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    default Shoppinglist partialUpdate(ShoppinglistDto shoppinglistDto, @MappingTarget Shoppinglist shoppinglist) {
        if (shoppinglistDto.getId() != null) {
            shoppinglist.setId(shoppinglistDto.getId());
        }
        if (shoppinglistDto.getCreatedat() == null) {
            shoppinglist.setCreatedat(shoppinglist.getCreatedat());
        }
        return shoppinglist;
    }

    @AfterMapping
    default void linkIngredientitems(@MappingTarget Shoppinglist shoppinglist) {
        shoppinglist.getIngredientitems().forEach(ingredientitem -> ingredientitem.setShoppinglistid(shoppinglist));
    }

    @AfterMapping
    default void linkNonfooditems(@MappingTarget Shoppinglist shoppinglist) {
        shoppinglist.getNonfooditems().forEach(nonfooditem -> nonfooditem.setShoppinglistid(shoppinglist));
    }
}
