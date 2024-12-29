package xyz.victorl.scrontch.comment.dto;

import lombok.Value;
import xyz.victorl.scrontch.comment.entity.CommentStatus;

import java.io.Serializable;

/**
 * DTO for {@link CommentStatus}
 */
@Value
public class CommentStatusDto implements Serializable {
    Integer id;
    String statusname;
}