package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stepingredient")
public class Stepingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stepingredient_id_gen")
    @SequenceGenerator(name = "stepingredient_id_gen", sequenceName = "stepingredient_stepingredient_seq", allocationSize = 1)
    @Column(name = "stepingredient", nullable = false)
    private Integer id;

    @Column(name = "ingredientid", nullable = false)
    private Integer ingredientid;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "isoptional", nullable = false)
    private Boolean isoptional = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stepid", nullable = false)
    private Step stepid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unitid")
    private Unit unitid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "preparationid", nullable = false)
    private Preparationmethod preparationid;

}