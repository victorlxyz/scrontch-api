package xyz.victorl.scrontch.recipe.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.entity.Step;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {StepingredientMapper.class})
public interface StepMapper {
    Step toEntity(RecipeDto.StepDto stepDto);

    RecipeDto.StepDto toDto(Step step);

    @AfterMapping
    default void linkStepingredients(@MappingTarget Step step) {
        step.getStepingredients().forEach(stepingredient -> stepingredient.setStepid(step));
    }

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Step partialUpdate(RecipeDto.StepDto stepDto, @MappingTarget Step step);
}
