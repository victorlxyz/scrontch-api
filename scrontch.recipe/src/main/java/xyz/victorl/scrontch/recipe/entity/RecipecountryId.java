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
public class RecipecountryId implements java.io.Serializable {
    private static final long serialVersionUID = -2595696864445382637L;
    @Column(name = "countryid", nullable = false)
    private Integer countryid;

    @Column(name = "recipeid", nullable = false)
    private Integer recipeid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecipecountryId entity = (RecipecountryId) o;
        return Objects.equals(this.countryid, entity.countryid) &&
                Objects.equals(this.recipeid, entity.recipeid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryid, recipeid);
    }

}