package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_id_gen")
    @SequenceGenerator(name = "status_id_gen", sequenceName = "status_statusid_seq", allocationSize = 1)
    @Column(name = "statusid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

}