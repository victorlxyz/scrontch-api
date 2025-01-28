package xyz.victorl.scrontch.shoppinglist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientitemDto implements Serializable {
    Integer id;
    Integer ingredientid;
    String ingredientitemdescription;
    Integer recipeid;
    private Integer shoppinglistid;
}