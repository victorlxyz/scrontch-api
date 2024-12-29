package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.UnitDto;
import xyz.victorl.scrontch.recipe.entity.Unit;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UnitMapper {
    Unit toEntity(UnitDto unitDto);

    UnitDto toDto(Unit unit);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Unit partialUpdate(UnitDto unitDto, @MappingTarget Unit unit);
}