package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.TypeDto;
import xyz.victorl.scrontch.recipe.entity.Type;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TypeMapper {
    Type toEntity(TypeDto typeDto);

    TypeDto toDto(Type type);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Type partialUpdate(TypeDto typeDto, @MappingTarget Type type);
}