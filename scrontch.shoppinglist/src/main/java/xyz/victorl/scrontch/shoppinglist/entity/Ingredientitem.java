package xyz.victorl.scrontch.shoppinglist.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ingredientitem")
public class Ingredientitem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredientitem_id_gen")
    @SequenceGenerator(name = "ingredientitem_id_gen", sequenceName = "ingredientitem_ingredientitemid_seq", allocationSize = 1)
    @Column(name = "ingredientitemid", nullable = false)
    private Integer id;

    @Column(name = "ingredientid")
    private Integer ingredientid;

    @Column(name = "ingredientitemdescription", length = 100)
    private String ingredientitemdescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shoppinglistid", nullable = false)
    private Shoppinglist shoppinglistid;

}