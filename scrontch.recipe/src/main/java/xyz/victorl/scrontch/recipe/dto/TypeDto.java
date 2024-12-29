package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Type}
 */
@Value
public class TypeDto implements Serializable {
    Integer id;
    String typename;
}