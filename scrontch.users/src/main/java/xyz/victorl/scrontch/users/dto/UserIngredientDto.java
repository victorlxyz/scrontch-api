package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.UserIngredient}
 */
@Value
public class UserIngredientDto implements Serializable {
    Integer id;
    Integer ingredientid;
    UserDto userid;
    Boolean isessential;
}