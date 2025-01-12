package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.entity.UserFavorite;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface UserFavoriteMapper {
    UserFavorite toEntity(UserFavoriteDto userFavoriteDto);

    UserFavoriteDto toDto(UserFavorite userFavorite);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserFavorite partialUpdate(UserFavoriteDto userFavoriteDto, @MappingTarget UserFavorite userFavorite);
}