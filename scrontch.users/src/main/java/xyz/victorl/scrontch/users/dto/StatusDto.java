package xyz.victorl.scrontch.users.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.users.entity.Status}
 */
@Value
public class StatusDto implements Serializable {
    Integer id;
    String name;
}