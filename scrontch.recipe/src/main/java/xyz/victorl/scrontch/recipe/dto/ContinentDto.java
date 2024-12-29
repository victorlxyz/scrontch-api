package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Continent}
 */
@Value
public class ContinentDto implements Serializable {
    Integer id;
    String continentname;
}