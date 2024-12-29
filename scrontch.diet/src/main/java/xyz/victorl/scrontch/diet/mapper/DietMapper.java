package xyz.victorl.scrontch.diet.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.diet.dto.DietDto;
import xyz.victorl.scrontch.diet.entity.Diet;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DietMapper {
    Diet toEntity(DietDto dietDto);

    DietDto toDto(Diet diet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Diet partialUpdate(DietDto dietDto, @MappingTarget Diet diet);
}