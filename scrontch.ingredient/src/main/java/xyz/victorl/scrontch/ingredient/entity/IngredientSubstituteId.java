package xyz.victorl.scrontch.ingredient.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IngredientSubstituteId implements Serializable {
    private static final long serialVersionUID = 5371081242842657862L;
    @Column(name = "ingredientid", nullable = false)
    private Integer ingredientId;

    @Column(name = "substituteingredientid", nullable = false)
    private Integer substituteIngredientId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientSubstituteId entity = (IngredientSubstituteId) o;
        return Objects.equals(this.ingredientId, entity.ingredientId) &&
                Objects.equals(this.substituteIngredientId, entity.substituteIngredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientId, substituteIngredientId);
    }

}