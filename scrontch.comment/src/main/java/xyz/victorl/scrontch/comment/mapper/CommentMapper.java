package xyz.victorl.scrontch.comment.mapper;

import org.mapstruct.*;
import xyz.victorl.scrontch.comment.dto.CommentDto;
import xyz.victorl.scrontch.comment.entity.Comment;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommentStatusMapper.class})
public interface CommentMapper {
    Comment toEntity(CommentDto commentDto);

    CommentDto toDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Comment partialUpdate(CommentDto commentDto, @MappingTarget Comment comment);
}