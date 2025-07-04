package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.UserDto;
import xyz.victorl.scrontch.users.entity.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {RoleMapper.class, StatusMapper.class})
public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);

    User map(Integer userId);
}