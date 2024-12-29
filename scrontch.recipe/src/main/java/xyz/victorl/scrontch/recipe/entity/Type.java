package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "type")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_id_gen")
    @SequenceGenerator(name = "type_id_gen", sequenceName = "type_typeid_seq", allocationSize = 1)
    @Column(name = "typeid", nullable = false)
    private Integer id;

    @Column(name = "typename", nullable = false, length = 100)
    private String typename;

    @Column(name = "typeicon", nullable = true, length = 255)
    private String typeicon;

    @OneToMany(mappedBy = "typeid")
    private Set<Recipe> recipes = new LinkedHashSet<>();

}