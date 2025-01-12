package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.EssentialIngredient}
 */
@Value
public class EssentialIngredientDto implements Serializable {
    Integer id;
    Integer ingredientid;
    Integer userid;
}