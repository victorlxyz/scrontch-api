package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.PreparationmethodDto;
import xyz.victorl.scrontch.recipe.entity.Preparationmethod;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PreparationmethodMapper {
    Preparationmethod toEntity(PreparationmethodDto preparationmethodDto);

    PreparationmethodDto toDto(Preparationmethod preparationmethod);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Preparationmethod partialUpdate(PreparationmethodDto preparationmethodDto, @MappingTarget Preparationmethod preparationmethod);
}