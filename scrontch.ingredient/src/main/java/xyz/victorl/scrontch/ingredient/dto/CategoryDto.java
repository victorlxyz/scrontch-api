package xyz.victorl.scrontch.ingredient.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.ingredient.entity.Category}
 */
@Value
public class CategoryDto implements Serializable {
    Integer id;
    String name;
    String icon;
}