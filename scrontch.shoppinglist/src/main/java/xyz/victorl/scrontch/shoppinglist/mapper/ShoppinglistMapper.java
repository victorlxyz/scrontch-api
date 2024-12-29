package xyz.victorl.scrontch.shoppinglist.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {IngredientitemMapper.class, NonfooditemMapper.class})
public interface ShoppinglistMapper {
    Shoppinglist toEntity(ShoppinglistDto shoppinglistDto);

    @AfterMapping
    default void linkIngredientitems(@MappingTarget Shoppinglist shoppinglist) {
        shoppinglist.getIngredientitems().forEach(ingredientitem -> ingredientitem.setShoppinglistid(shoppinglist));
    }

    @AfterMapping
    default void linkNonfooditems(@MappingTarget Shoppinglist shoppinglist) {
        shoppinglist.getNonfooditems().forEach(nonfooditem -> nonfooditem.setShoppinglistid(shoppinglist));
    }

    ShoppinglistDto toDto(Shoppinglist shoppinglist);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Shoppinglist partialUpdate(ShoppinglistDto shoppinglistDto, @MappingTarget Shoppinglist shoppinglist);
}