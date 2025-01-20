package xyz.victorl.scrontch.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.UserDiet}
 */
@Getter
@Setter
public class UserDietDto implements Serializable {
    Integer id;
    Integer dietid;
    Integer userid;
}