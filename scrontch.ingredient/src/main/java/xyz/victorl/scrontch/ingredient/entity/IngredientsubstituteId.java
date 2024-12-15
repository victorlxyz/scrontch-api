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
public class IngredientsubstituteId implements Serializable {
    private static final long serialVersionUID = 4644614689052832658L;
    @Column(name = "ingredientid", nullable = false)
    private Integer ingredientid;

    @Column(name = "substituteingredientid", nullable = false)
    private Integer substituteingredientid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientsubstituteId entity = (IngredientsubstituteId) o;
        return Objects.equals(this.ingredientid, entity.ingredientid) &&
                Objects.equals(this.substituteingredientid, entity.substituteingredientid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientid, substituteingredientid);
    }

}