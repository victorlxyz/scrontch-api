package xyz.victorl.scrontch.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.comment.dto.CommentStatusDto;
import xyz.victorl.scrontch.comment.entity.CommentStatus;
import xyz.victorl.scrontch.comment.mapper.CommentStatusMapper;
import xyz.victorl.scrontch.comment.repository.CommentStatusRepository;
import xyz.victorl.scrontch.comment.service.StatusService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusServiceImpl implements StatusService {

    private final CommentStatusRepository commentStatusRepository;
    private final CommentStatusMapper commentStatusMapper;

    @Override
    public List<CommentStatusDto> findAll() {
        return commentStatusRepository.findAll()
                .stream()
                .map(commentStatusMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentStatusDto findById(Integer id) {
        CommentStatus commentStatus = commentStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        return commentStatusMapper.toDto(commentStatus);
    }

    @Override
    public CommentStatusDto create(CommentStatusDto commentStatusDto) {
        CommentStatus commentStatus = commentStatusMapper.toEntity(commentStatusDto);
        return commentStatusMapper.toDto(commentStatusRepository.save(commentStatus));
    }

    @Override
    public CommentStatusDto update(Integer id, CommentStatusDto commentStatusDto) {
        CommentStatus commentStatus = commentStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        commentStatusMapper.partialUpdate(commentStatusDto, commentStatus);
        return commentStatusMapper.toDto(commentStatusRepository.save(commentStatus));
    }

    @Override
    public void delete(Integer id) {
        if (!commentStatusRepository.existsById(id)) {
            throw new RuntimeException("Status not found");
        }
        commentStatusRepository.deleteById(id);
    }
}
