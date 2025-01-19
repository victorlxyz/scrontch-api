package xyz.victorl.scrontch.shoppinglist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "recipelist")
public class Recipelist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipelist_id_gen")
    @SequenceGenerator(name = "recipelist_id_gen", sequenceName = "recipelist_recipelistid_seq", allocationSize = 1)
    @Column(name = "recipelistid", nullable = false)
    private Integer id;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @OneToMany(mappedBy = "recipelistid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Recipeitem> recipeitems = new LinkedHashSet<>();

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