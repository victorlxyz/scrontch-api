package xyz.victorl.scrontch.common.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;


@Data
public class IngredientDto implements Serializable {
    Integer id;
    String name;
    String alias;
    String image;
    String description;
    Instant createdat;
    Instant updatedat;
    Integer categoryid;
    Boolean isFemale;
}