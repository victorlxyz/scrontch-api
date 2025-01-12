package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.EssentialIngredientDto;
import xyz.victorl.scrontch.users.entity.EssentialIngredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface EssentialIngredientMapper {
    EssentialIngredient toEntity(EssentialIngredientDto essentialIngredientDto);

    EssentialIngredientDto toDto(EssentialIngredient essentialIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EssentialIngredient partialUpdate(EssentialIngredientDto essentialIngredientDto, @MappingTarget EssentialIngredient essentialIngredient);
}