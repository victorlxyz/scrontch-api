package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.common.service.UserService;
import java.util.List;

public interface ShoppinglistService {
    List<ShoppinglistDto> findAll();

    ShoppinglistDto findById(Integer id);

    ShoppinglistDto create(ShoppinglistDto shoppinglistDto);

    ShoppinglistDto update(Integer id, ShoppinglistDto shoppinglistDto);

    void delete(Integer id);

    List<ShoppinglistDto> findByUserId(Integer userid);

    IngredientitemDto addIngredientToShoppinglist(Integer shoppinglistId, IngredientitemDto ingredientitemDto);

    NonfooditemDto addNonFoodItemToShoppinglist(Integer shoppinglistId, NonfooditemDto nonfooditemDto);

    void deleteShoppingList(Integer listId);

    void createDefaultListIfNotExists(Integer id);
}
