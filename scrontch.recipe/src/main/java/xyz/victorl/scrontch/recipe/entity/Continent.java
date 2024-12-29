package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "continent")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "continent_id_gen")
    @SequenceGenerator(name = "continent_id_gen", sequenceName = "continent_continentid_seq", allocationSize = 1)
    @Column(name = "continentid", nullable = false)
    private Integer id;

    @Column(name = "continentname", nullable = false, length = 100)
    private String continentname;

}