package xyz.victorl.scrontch.diet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "diet")
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diet_id_gen")
    @SequenceGenerator(name = "diet_id_gen", sequenceName = "diet_dietid_seq", allocationSize = 1)
    @Column(name = "dietid", nullable = false)
    private Integer id;

    @Column(name = "dietname", nullable = false, length = 150)
    private String dietname;

    @Column(name = "icon")
    private String icon;

}