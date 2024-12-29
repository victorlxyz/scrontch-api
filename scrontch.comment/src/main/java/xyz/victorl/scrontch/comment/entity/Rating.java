package xyz.victorl.scrontch.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rating_id_gen")
    @SequenceGenerator(name = "rating_id_gen", sequenceName = "rating_ratingid_seq", allocationSize = 1)
    @Column(name = "ratingid", nullable = false)
    private Integer id;

    @Column(name = "recipeid", nullable = false)
    private Integer recipeid;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

}