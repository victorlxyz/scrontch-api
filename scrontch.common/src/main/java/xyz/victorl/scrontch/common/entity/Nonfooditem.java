package xyz.victorl.scrontch.common.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "nonfooditem")
public class Nonfooditem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nonfooditem_id_gen")
    @SequenceGenerator(name = "nonfooditem_id_gen", sequenceName = "nonfooditem_nonfooditemid_seq", allocationSize = 1)
    @Column(name = "nonfooditemid", nullable = false)
    private Integer id;

    @Column(name = "nonfooditemname", nullable = false, length = 100)
    private String nonfooditemname;

    @Column(name = "nonfooditemdescription", length = 100)
    private String nonfooditemdescription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shoppinglistid", nullable = false)
    private Shoppinglist shoppinglistid;

}