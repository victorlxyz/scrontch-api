package xyz.victorl.scrontch.diet.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.diet.entity.Diet}
 */
@Value
public class DietDto implements Serializable {
    Integer id;
    String dietname;
    String icon;
}