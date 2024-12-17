package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.User}
 */
@Value
public class UserDto implements Serializable {
    Integer id;
    String username;
    String email;
    String passwordhash;
    String avatarurl;
    Instant createdat;
    Instant updatedat;
    Instant lastloginat;
    Boolean ispushnotifyenabled;
    Boolean isemailnotifyenabled;
    RoleDto roleid;
    StatusDto statusid;
}