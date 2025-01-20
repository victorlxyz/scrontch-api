package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserDiet;
import xyz.victorl.scrontch.users.repository.UserRepository;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserDietMapper {
    @Mapping(source = "userid.id", target = "userid")
    UserDietDto toDto(UserDiet userDiet);

    @Mapping(source = "userid", target = "userid")
    UserDiet toEntity(UserDietDto userDietDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserDiet partialUpdate(UserDietDto userDietDto, @MappingTarget UserDiet userDiet);
}
