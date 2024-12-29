package xyz.victorl.scrontch.comment.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link xyz.victorl.scrontch.comment.entity.Comment}
 */
@Value
public class CommentDto implements Serializable {
    Integer id;
    Integer recipeid;
    Integer userid;
    Integer parentcommentid;
    String content;
    Instant createdat;
    Instant updatedat;
    Instant deletedat;
    Integer likes;
    Integer dislikes;
    CommentStatusDto statusid;
}