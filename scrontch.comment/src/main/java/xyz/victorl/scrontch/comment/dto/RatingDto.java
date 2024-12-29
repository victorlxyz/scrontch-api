package xyz.victorl.scrontch.comment.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link xyz.victorl.scrontch.comment.entity.Rating}
 */
@Value
public class RatingDto implements Serializable {
    Integer id;
    Integer recipeid;
    Integer userid;
    Integer rating;
    Instant createdat;
    Instant updatedat;
}