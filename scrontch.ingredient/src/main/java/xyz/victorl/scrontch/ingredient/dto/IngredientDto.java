package xyz.victorl.scrontch.ingredient.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link xyz.victorl.scrontch.ingredient.entity.Ingredient}
 */
@Value
public class IngredientDto implements Serializable {
    Integer id;
    String name;
    String image;
    String description;
    Instant createdat;
    Instant updatedat;
    Integer categoryid;
}