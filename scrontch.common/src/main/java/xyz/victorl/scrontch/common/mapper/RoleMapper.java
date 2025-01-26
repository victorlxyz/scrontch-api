package xyz.victorl.scrontch.common.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import xyz.victorl.scrontch.common.dto.RoleDto;
import xyz.victorl.scrontch.common.entity.Role;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}