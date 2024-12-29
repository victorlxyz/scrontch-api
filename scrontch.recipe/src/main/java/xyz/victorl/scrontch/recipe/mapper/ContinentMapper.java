package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.ContinentDto;
import xyz.victorl.scrontch.recipe.entity.Continent;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContinentMapper {
    Continent toEntity(ContinentDto continentDto);

    ContinentDto toDto(Continent continent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Continent partialUpdate(ContinentDto continentDto, @MappingTarget Continent continent);
}