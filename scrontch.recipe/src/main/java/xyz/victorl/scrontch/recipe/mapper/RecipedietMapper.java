package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.RecipedietDto;
import xyz.victorl.scrontch.recipe.entity.Recipediet;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecipedietMapper {
    Recipediet toEntity(RecipedietDto recipedietDto);

    RecipedietDto toDto(Recipediet recipediet);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Recipediet partialUpdate(RecipedietDto recipedietDto, @MappingTarget Recipediet recipediet);
}