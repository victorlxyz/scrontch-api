package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "preparationmethod")
public class Preparationmethod {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preparationmethod_id_gen")
    @SequenceGenerator(name = "preparationmethod_id_gen", sequenceName = "preparationmethod_preparationid_seq", allocationSize = 1)
    @Column(name = "preparationid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

}