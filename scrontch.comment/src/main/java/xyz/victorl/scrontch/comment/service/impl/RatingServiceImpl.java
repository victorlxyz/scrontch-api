package xyz.victorl.scrontch.comment.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.comment.dto.RatingDto;
import xyz.victorl.scrontch.comment.entity.Rating;
import xyz.victorl.scrontch.comment.mapper.RatingMapper;
import xyz.victorl.scrontch.comment.repository.RatingRepository;
import xyz.victorl.scrontch.comment.service.RatingService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;
    private final RatingMapper ratingMapper;

    @Override
    public List<RatingDto> findAll() {
        return ratingRepository.findAll()
                .stream()
                .map(ratingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RatingDto findById(Integer id) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));
        return ratingMapper.toDto(rating);
    }

    @Override
    public RatingDto create(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        return ratingMapper.toDto(ratingRepository.save(rating));
    }

    @Override
    public RatingDto update(Integer id, RatingDto ratingDto) {
        Rating rating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found"));

        ratingMapper.partialUpdate(ratingDto, rating);
        return ratingMapper.toDto(ratingRepository.save(rating));
    }

    @Override
    public void delete(Integer id) {
        if (!ratingRepository.existsById(id)) {
            throw new RuntimeException("Rating not found");
        }
        ratingRepository.deleteById(id);
    }
}
