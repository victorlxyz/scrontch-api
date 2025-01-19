package xyz.victorl.scrontch.shoppinglist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipeitem")
public class Recipeitem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeitem_id_gen")
    @SequenceGenerator(name = "recipeitem_id_gen", sequenceName = "recipeitem_recipeitemid_seq", allocationSize = 1)
    @Column(name = "recipeitemid", nullable = false)
    private Integer id;

    @Column(name = "recipeid")
    private Integer recipeid;

    @Column(name = "recipename", length = 150)
    private String recipename;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipelistid", nullable = false)
    private Recipelist recipelistid;

}
