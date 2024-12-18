package xyz.victorl.scrontch.users.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Getter
@Setter
public class EmailVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    private Instant expiryDate;
}

