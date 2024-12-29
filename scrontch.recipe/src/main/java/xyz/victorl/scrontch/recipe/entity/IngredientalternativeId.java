package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IngredientalternativeId implements java.io.Serializable {
    private static final long serialVersionUID = 5814302987423510374L;
    @Column(name = "ingredientid", nullable = false)
    private Integer ingredientid;

    @Column(name = "alternativeingredientid", nullable = false)
    private Integer alternativeingredientid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        IngredientalternativeId entity = (IngredientalternativeId) o;
        return Objects.equals(this.ingredientid, entity.ingredientid) &&
                Objects.equals(this.alternativeingredientid, entity.alternativeingredientid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientid, alternativeingredientid);
    }

}