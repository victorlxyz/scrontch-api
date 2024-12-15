package xyz.victorl.scrontch.ingredient.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.ingredient.dto.CategoryDto;
import xyz.victorl.scrontch.ingredient.entity.Category;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);

    CategoryDto toDto(Category category);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category partialUpdate(CategoryDto categoryDto, @MappingTarget Category category);
}