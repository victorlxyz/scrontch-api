package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredientalternatives")
public class Ingredientalternative {
    @SequenceGenerator(name = "ingredientalternatives_id_gen", sequenceName = "country_countryid_seq", allocationSize = 1)
    @EmbeddedId
    private IngredientalternativeId id;

}