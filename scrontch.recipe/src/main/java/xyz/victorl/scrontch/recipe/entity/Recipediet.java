package xyz.victorl.scrontch.recipe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipediet")
public class Recipediet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipediet_id_gen")
    @SequenceGenerator(name = "recipediet_id_gen", sequenceName = "recipediet_recipedietid_seq", allocationSize = 1)
    @Column(name = "recipedietid", nullable = false)
    private Integer id;

    @Column(name = "dietid", nullable = false)
    private Integer dietid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipeid", nullable = false)
    private Recipe recipeid;

}