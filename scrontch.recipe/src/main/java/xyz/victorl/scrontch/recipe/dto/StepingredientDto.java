package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Stepingredient}
 */
@Value
public class StepingredientDto implements Serializable {
    Integer id;
    Integer ingredientid;
    Double quantity;
    Boolean isoptional;
    UnitDto unitid;
    PreparationmethodDto preparationid;

}