package xyz.victorl.scrontch.ingredient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredientsubstitute")
public class Ingredientsubstitute {
    @SequenceGenerator(name = "ingredientsubstitute_id_gen", sequenceName = "ingredient_ingredientid_seq", allocationSize = 1)
    @EmbeddedId
    private IngredientsubstituteId id;

    @MapsId("ingredientid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredientid", nullable = false)
    private Ingredient ingredientid;

    @MapsId("substituteingredientid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "substituteingredientid", nullable = false)
    private Ingredient substituteingredientid;

}