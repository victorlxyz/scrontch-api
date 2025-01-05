package xyz.victorl.scrontch.recipe.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link xyz.victorl.scrontch.recipe.entity.Preparationmethod}
 */

@Getter
@Setter
public class PreparationmethodDto implements Serializable {
    Integer id;
    String name;

    public PreparationmethodDto(Integer id) {
        this.id = id;
    }

    public PreparationmethodDto() {
    }
}