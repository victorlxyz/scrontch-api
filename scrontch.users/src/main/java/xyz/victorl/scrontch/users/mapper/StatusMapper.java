package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.StatusDto;
import xyz.victorl.scrontch.users.entity.Status;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatusMapper {
    Status toEntity(StatusDto statusDto);

    StatusDto toDto(Status status);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Status partialUpdate(StatusDto statusDto, @MappingTarget Status status);
}