package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_id_gen")
    @SequenceGenerator(name = "unit_id_gen", sequenceName = "unit_unitid_seq", allocationSize = 1)
    @Column(name = "unitid", nullable = false)
    private Integer id;

    @Column(name = "unitname", nullable = false, length = 60)
    private String unitname;

}