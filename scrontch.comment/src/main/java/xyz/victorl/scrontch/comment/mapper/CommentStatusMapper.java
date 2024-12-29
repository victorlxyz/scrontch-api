package xyz.victorl.scrontch.comment.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.comment.dto.CommentStatusDto;
import xyz.victorl.scrontch.comment.entity.CommentStatus;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommentStatusMapper {
    CommentStatus toEntity(CommentStatusDto commentStatusDto);

    CommentStatusDto toDto(CommentStatus commentStatus);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CommentStatus partialUpdate(CommentStatusDto commentStatusDto, @MappingTarget CommentStatus commentStatus);
}