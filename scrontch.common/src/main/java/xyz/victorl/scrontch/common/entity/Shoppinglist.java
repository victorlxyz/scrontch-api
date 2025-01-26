package xyz.victorl.scrontch.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shoppinglist")
public class Shoppinglist {
    public static final String DEFAULT_LIST_NAME = "Liste de courses";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shoppinglist_id_gen")
    @SequenceGenerator(name = "shoppinglist_id_gen", sequenceName = "shoppinglist_shoppinglistid_seq", allocationSize = 1)
    @Column(name = "shoppinglistid", nullable = false)
    private Integer id;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @OneToMany(mappedBy = "shoppinglistid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ingredientitem> ingredientitems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "shoppinglistid", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Nonfooditem> nonfooditems = new LinkedHashSet<>();

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