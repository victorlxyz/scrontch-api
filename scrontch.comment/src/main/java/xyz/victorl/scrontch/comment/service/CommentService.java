package xyz.victorl.scrontch.comment.service;

import xyz.victorl.scrontch.comment.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    CommentDto findById(Integer id);

    CommentDto create(CommentDto commentDto);

    CommentDto update(Integer id, CommentDto commentDto);

    void delete(Integer id);
}
