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

    // Remove the conflicting mapping method
    // @Mapping(target = "id", expression = "java(mapIntegerToUser(userDietDto.getUserid()))")

    // The method that converts Integer to User
    default User mapIntegerToUser(Integer userid) {
        // Fetch the user from the repository
        // This example assumes the UserRepository is available
        // You can inject UserRepository into this mapper if needed

        return new User();  // Replace this with actual repository call or user lookup logic
    }
}
