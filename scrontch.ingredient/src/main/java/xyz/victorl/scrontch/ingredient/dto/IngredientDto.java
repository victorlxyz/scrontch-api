package xyz.victorl.scrontch.ingredient.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link xyz.victorl.scrontch.ingredient.entity.Ingredient}
 */
@Data
public class IngredientDto implements Serializable {
    Integer id;
    String name;
    String image;
    String description;
    Instant createdat;
    Instant updatedat;
    Integer categoryid;
    List<IngredientSubstituteDto> substitutes;
}