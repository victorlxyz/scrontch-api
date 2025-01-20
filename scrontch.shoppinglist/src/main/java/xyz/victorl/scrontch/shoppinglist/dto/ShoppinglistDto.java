package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppinglistDto implements Serializable {
    private Integer id;
    private Integer userid;
    private String name;
    private Instant createdat;
    private Instant updatedat;
    private Set<IngredientitemDto> ingredientitems;
    private Set<NonfooditemDto> nonfooditems;
}