package xyz.victorl.scrontch.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_gen")
    @SequenceGenerator(name = "comment_id_gen", sequenceName = "comment_commentid_seq", allocationSize = 1)
    @Column(name = "commentid", nullable = false)
    private Integer id;

    @Column(name = "recipeid", nullable = false)
    private Integer recipeid;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "parentcommentid")
    private Integer parentcommentid;

    @Column(name = "content", nullable = false, length = 2000)
    private String content;

    @Column(name = "createdat", nullable = false)
    private Instant createdat;

    @Column(name = "updatedat")
    private Instant updatedat;

    @Column(name = "deletedat")
    private Instant deletedat;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    @Column(name = "dislikes", nullable = false)
    private Integer dislikes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "statusid", nullable = false)
    private CommentStatus statusid;

}