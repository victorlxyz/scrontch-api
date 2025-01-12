package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.UserDiet}
 */
@Value
public class UserDietDto implements Serializable {
    Integer id;
    Integer dietid;
    Integer userid;
}