package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import xyz.victorl.scrontch.common.entity.User;

@Getter
@Setter
@Entity
@Table(name = "userdiet")
public class UserDiet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdiet_id_gen")
    @SequenceGenerator(name = "userdiet_id_gen", sequenceName = "userdiet_userdietid_seq", allocationSize = 1)
    @Column(name = "userdietid", nullable = false)
    private Integer id;

    @Column(name = "dietid", nullable = false)
    private Integer dietid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

}