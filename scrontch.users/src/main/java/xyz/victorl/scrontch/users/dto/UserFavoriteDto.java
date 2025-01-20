package xyz.victorl.scrontch.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.UserFavorite}
 */
@Getter
@Setter
public class UserFavoriteDto implements Serializable {
    Integer id;
    Integer recipeid;
    Integer userid;
}