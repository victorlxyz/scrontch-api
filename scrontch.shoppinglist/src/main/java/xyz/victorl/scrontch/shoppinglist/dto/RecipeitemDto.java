package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.shoppinglist.entity.Recipeitem}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeitemDto implements Serializable {
    Integer id;
    Integer recipeid;
    String recipename;
    private Integer recipelistid;
}