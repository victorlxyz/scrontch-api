package xyz.victorl.scrontch.users.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.users.dto.EssentialIngredientDto;
import xyz.victorl.scrontch.users.entity.EssentialIngredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface EssentialIngredientMapper {

    @Mapping(source = "userid", target = "userid")
    EssentialIngredient toEntity(EssentialIngredientDto essentialIngredientDto);

    @Mapping(source = "userid.id", target = "userid")
    EssentialIngredientDto toDto(EssentialIngredient essentialIngredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    EssentialIngredient partialUpdate(EssentialIngredientDto essentialIngredientDto, @MappingTarget EssentialIngredient essentialIngredient);
}