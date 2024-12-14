package xyz.victorl.scrontch.ingredient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredientsubstitute")
public class IngredientSubstitute {
    @SequenceGenerator(name = "ingredientsubstitute_id_gen", sequenceName = "ingredient_ingredientid_seq", allocationSize = 1)
    @EmbeddedId
    private IngredientSubstituteId id;

    @MapsId("ingredientid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ingredientid", nullable = false)
    private Ingredient ingredientId;

    @MapsId("substituteingredientid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "substituteingredientid", nullable = false)
    private Ingredient substituteIngredientId;

}