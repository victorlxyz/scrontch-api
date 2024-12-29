package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipe_id_gen")
    @SequenceGenerator(name = "recipe_id_gen", sequenceName = "recipe_recipeid_seq", allocationSize = 1)
    @Column(name = "recipeid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "description", nullable = false, length = 2000)
    private String description;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @Column(name = "portions", nullable = false)
    private Double portions;

    @Column(name = "notes", length = 2000)
    private String notes;

    @Column(name = "image", nullable = false, length = 150)
    private String image;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "typeid", nullable = false)
    private Type typeid;

    @ManyToMany
    @JoinTable(name = "recipecountry",
            joinColumns = @JoinColumn(name = "recipeid"),
            inverseJoinColumns = @JoinColumn(name = "countryid"))
    private Set<Country> countries = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recipeid")
    private Set<Recipediet> recipediets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recipeid")
    private Set<Step> steps = new LinkedHashSet<>();

}