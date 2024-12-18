package xyz.victorl.scrontch.users.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_userid_seq", allocationSize = 1)
    @Column(name = "userid", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "passwordhash", nullable = false, length = 225)
    private String passwordhash;

    @Column(name = "avatarurl", length = 150)
    private String avatarurl;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @Column(name = "lastloginat")
    private Instant lastloginat;

    @Column(name = "ispushnotifyenabled", nullable = false)
    private Boolean ispushnotifyenabled = false;

    @Column(name = "isemailnotifyenabled", nullable = false)
    private Boolean isemailnotifyenabled = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "roleid", nullable = false)
    private Role roleid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "statusid", nullable = false)
    private Status statusid;

}