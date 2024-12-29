package xyz.victorl.scrontch.comment.service;

import xyz.victorl.scrontch.comment.dto.CommentStatusDto;

import java.util.List;

public interface StatusService {
    List<CommentStatusDto> findAll();

    CommentStatusDto findById(Integer id);

    CommentStatusDto create(CommentStatusDto commentStatusDto);

    CommentStatusDto update(Integer id, CommentStatusDto commentStatusDto);

    void delete(Integer id);
}
