package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Ingredientitem}
 */
@Value
public class IngredientitemDto implements Serializable {
    Integer id;
    Integer ingredientid;
    String ingredientitemdescription;
    Integer recipeid;
}