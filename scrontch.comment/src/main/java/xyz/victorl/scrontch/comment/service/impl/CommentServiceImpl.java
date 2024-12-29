package xyz.victorl.scrontch.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.comment.dto.CommentDto;
import xyz.victorl.scrontch.comment.entity.Comment;
import xyz.victorl.scrontch.comment.mapper.CommentMapper;
import xyz.victorl.scrontch.comment.repository.CommentRepository;
import xyz.victorl.scrontch.comment.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public List<CommentDto> findAll() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(Integer id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto create(CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public CommentDto update(Integer id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentMapper.partialUpdate(commentDto, comment);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Integer id) {
        if (!commentRepository.existsById(id)) {
            throw new RuntimeException("Comment not found");
        }
        commentRepository.deleteById(id);
    }
}
