package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Unit}
 */
@Value
public class UnitDto implements Serializable {
    Integer id;
    String unitname;
}