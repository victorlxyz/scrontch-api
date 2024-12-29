package xyz.victorl.scrontch.recipe.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Country}
 */
@Value
public class CountryDto implements Serializable {
    Integer id;
    String name;
    ContinentDto continentid;
}