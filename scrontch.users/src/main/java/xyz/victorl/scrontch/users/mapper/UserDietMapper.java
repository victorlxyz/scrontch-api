package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.entity.UserDiet;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserDietMapper {
    UserDiet toEntity(UserDietDto userDietDto);

    UserDietDto toDto(UserDiet userDiet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserDiet partialUpdate(UserDietDto userDietDto, @MappingTarget UserDiet userDiet);
}