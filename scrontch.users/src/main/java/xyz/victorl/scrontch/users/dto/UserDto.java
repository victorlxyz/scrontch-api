package xyz.victorl.scrontch.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.User}
 */
@Getter
@Setter
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
    Boolean emailVerified;
    RoleDto roleid;
    StatusDto statusid;
}