package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipecountry")
public class Recipecountry {
    @SequenceGenerator(name = "recipecountry_id_gen", sequenceName = "recipe_recipeid_seq", allocationSize = 1)
    @EmbeddedId
    private RecipecountryId id;

    @MapsId("countryid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countryid", nullable = false)
    private xyz.victorl.scrontch.users.entity.Country countryid;

    @MapsId("recipeid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipeid", nullable = false)
    private xyz.victorl.scrontch.users.entity.Recipe recipeid;

}