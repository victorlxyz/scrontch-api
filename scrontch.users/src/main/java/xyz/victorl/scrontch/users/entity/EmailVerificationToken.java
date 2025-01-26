package xyz.victorl.scrontch.users.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import xyz.victorl.scrontch.common.entity.User;

import java.time.Instant;

@Entity
@Getter
@Setter
public class EmailVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    private User user;

    private Instant expiryDate;
}

