package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.common.mapper.UserMapper;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.entity.UserIngredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserIngredientMapper {

    @Mapping(source = "userid", target = "userid")
    UserIngredient toEntity(UserIngredientDto userIngredientDto);

    @Mapping(source = "userid.id", target = "userid")
    UserIngredientDto toDto(UserIngredient userIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserIngredient partialUpdate(UserIngredientDto userIngredientDto, @MappingTarget UserIngredient userIngredient);
}