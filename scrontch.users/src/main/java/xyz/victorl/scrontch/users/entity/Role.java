package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_gen")
    @SequenceGenerator(name = "role_id_gen", sequenceName = "role_roleid_seq", allocationSize = 1)
    @Column(name = "roleid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

}