package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Recipeitem}
 */
@Value
public class RecipeitemDto implements Serializable {
    Integer id;
    Integer recipeid;
    String recipename;
}