package xyz.victorl.scrontch.recipe.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Type}
 */
@Getter
@Setter
public class TypeDto implements Serializable {
    Integer id;
    String typename;
    String typeicon;

    public TypeDto(Integer id) {
        this.id = id;
    }

    public TypeDto() {
    }
}