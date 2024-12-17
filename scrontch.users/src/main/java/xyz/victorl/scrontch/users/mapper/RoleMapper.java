package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.RoleDto;
import xyz.victorl.scrontch.users.entity.Role;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto, @MappingTarget Role role);
}