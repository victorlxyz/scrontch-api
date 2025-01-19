package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Recipelist}
 */
@Value
public class RecipelistDto implements Serializable {
    Integer id;
    Integer userid;
    String name;
    Instant createdat;
    Instant updatedat;
    Set<RecipeitemDto> recipeitems;
}