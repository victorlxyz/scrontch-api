package xyz.victorl.scrontch.ingredient.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_id_gen")
    @SequenceGenerator(name = "ingredient_id_gen", sequenceName = "ingredient_ingredientid_seq", allocationSize = 1)
    @Column(name = "ingredientid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "description", length = 2000)
    private String description;

    @Column(name = "alias", length = 200)
    private String alias;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "categoryid", nullable = false)
    private Category categoryid;

    @Column(name = "isfemale", nullable = false)
    private Boolean isFemale = false;

    @PrePersist
    public void prePersist() {
        if (createdat == null) {
            createdat = Instant.now();
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedat = Instant.now();
    }

}