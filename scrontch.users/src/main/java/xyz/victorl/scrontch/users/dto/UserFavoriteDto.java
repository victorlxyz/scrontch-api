package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.UserFavorite}
 */
@Value
public class UserFavoriteDto implements Serializable {
    Integer id;
    Integer recipeid;
    UserDto userid;
}