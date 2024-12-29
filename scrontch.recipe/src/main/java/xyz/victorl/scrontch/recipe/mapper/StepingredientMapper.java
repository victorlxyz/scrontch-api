package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.StepingredientDto;
import xyz.victorl.scrontch.recipe.entity.Stepingredient;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {UnitMapper.class, PreparationmethodMapper.class})
public interface StepingredientMapper {
    Stepingredient toEntity(StepingredientDto stepingredientDto);

    StepingredientDto toDto(Stepingredient stepingredient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Stepingredient partialUpdate(StepingredientDto stepingredientDto, @MappingTarget Stepingredient stepingredient);
}