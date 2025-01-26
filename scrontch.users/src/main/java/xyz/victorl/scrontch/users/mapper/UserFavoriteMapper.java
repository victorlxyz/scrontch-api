package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.common.mapper.UserMapper;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.entity.UserFavorite;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserFavoriteMapper {

    @Mapping(source = "userid", target = "userid")
    UserFavorite toEntity(UserFavoriteDto userFavoriteDto);

    @Mapping(source = "userid.id", target = "userid")
    UserFavoriteDto toDto(UserFavorite userFavorite);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserFavorite partialUpdate(UserFavoriteDto userFavoriteDto, @MappingTarget UserFavorite userFavorite);
}