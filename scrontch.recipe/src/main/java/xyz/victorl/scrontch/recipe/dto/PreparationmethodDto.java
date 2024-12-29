package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Preparationmethod}
 */
@Value
public class PreparationmethodDto implements Serializable {
    Integer id;
    String name;
}