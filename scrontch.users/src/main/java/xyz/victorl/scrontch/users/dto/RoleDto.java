package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.Role}
 */
@Value
public class RoleDto implements Serializable {
    Integer id;
    String name;
}