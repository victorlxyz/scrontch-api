package xyz.victorl.scrontch.common.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import xyz.victorl.scrontch.common.dto.StatusDto;
import xyz.victorl.scrontch.common.entity.Status;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface StatusMapper {

    Status toEntity(StatusDto statusDto);

    StatusDto toDto(Status status);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Status partialUpdate(StatusDto statusDto, @MappingTarget Status status);
}