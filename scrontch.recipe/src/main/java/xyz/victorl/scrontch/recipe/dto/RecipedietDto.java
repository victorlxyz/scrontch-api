package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Recipediet}
 */
@Value
public class RecipedietDto implements Serializable {
    Integer id;
    Integer dietid;
}