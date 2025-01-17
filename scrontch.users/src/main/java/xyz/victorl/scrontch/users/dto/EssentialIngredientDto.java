package xyz.victorl.scrontch.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.EssentialIngredient}
 */
@Getter
@Setter
public class EssentialIngredientDto implements Serializable {
    Integer id;
    Integer ingredientid;
    Integer userid;
}