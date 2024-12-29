package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "step")
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "step_id_gen")
    @SequenceGenerator(name = "step_id_gen", sequenceName = "step_stepid_seq", allocationSize = 1)
    @Column(name = "stepid", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 150)
    private String title;

    @Column(name = "instructions", nullable = false, length = 2000)
    private String instructions;

    @Column(name = "length", nullable = false)
    private Integer length;

    @Column(name = "image", length = 150)
    private String image;

    @Column(name = "steporder", nullable = false)
    private Integer steporder;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipeid", nullable = false)
    private Recipe recipeid;

    @OneToMany(mappedBy = "stepid")
    private Set<Stepingredient> stepingredients = new LinkedHashSet<>();

}