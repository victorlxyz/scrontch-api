package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import xyz.victorl.scrontch.common.entity.User;

@Getter
@Setter
@Entity
@Table(name = "userfavorite")
public class UserFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userfavorite_id_gen")
    @SequenceGenerator(name = "userfavorite_id_gen", sequenceName = "userfavorite_userfavoriteid_seq", allocationSize = 1)
    @Column(name = "userfavoriteid", nullable = false)
    private Integer id;

    @Column(name = "recipeid", nullable = false)
    private Integer recipeid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

}