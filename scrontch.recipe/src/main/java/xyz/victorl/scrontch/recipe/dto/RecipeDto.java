package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Recipe}
 */
@Value
public class RecipeDto implements Serializable {
    Integer id;
    String name;
    String description;
    Integer difficulty;
    Double portions;
    String notes;
    String image;
    Instant createdat;
    Instant updatedat;
    TypeDto typeid;
    Set<CountryDto> countries;
    Set<RecipedietDto> recipediets;
    Set<StepDto> steps;

    /**
     * DTO for {@link xyz.victorl.scrontch.recipe.entity.Step}
     */
    @Value
    public static class StepDto implements Serializable {
        Integer id;
        String title;
        String instructions;
        Integer length;
        String image;
        Integer steporder;
        Set<StepingredientDto> stepingredients;
    }
}