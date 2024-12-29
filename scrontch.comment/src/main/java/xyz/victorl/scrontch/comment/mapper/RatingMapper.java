package xyz.victorl.scrontch.comment.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.comment.dto.RatingDto;
import xyz.victorl.scrontch.comment.entity.Rating;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RatingMapper {
    Rating toEntity(RatingDto ratingDto);

    RatingDto toDto(Rating rating);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Rating partialUpdate(RatingDto ratingDto, @MappingTarget Rating rating);
}