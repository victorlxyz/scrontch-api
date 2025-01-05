package xyz.victorl.scrontch.recipe.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Unit}
 */
@Getter
@Setter
public class UnitDto {
    private Integer id;
    private String unitname;

    public UnitDto(Integer id) {
        this.id = id;
    }

    public UnitDto() {
    }
}