package xyz.victorl.scrontch.ingredient.dto;

import lombok.Value;

import java.io.Serializable;

@Value
public class IngredientSubstituteDto implements Serializable {
    Integer ingredientId;
    Integer substituteingredientid;
}