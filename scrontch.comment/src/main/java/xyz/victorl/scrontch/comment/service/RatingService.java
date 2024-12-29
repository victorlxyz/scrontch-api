package xyz.victorl.scrontch.comment.service;

import xyz.victorl.scrontch.comment.dto.RatingDto;

import java.util.List;

public interface RatingService {
    List<RatingDto> findAll();

    RatingDto findById(Integer id);

    RatingDto create(RatingDto ratingDto);

    RatingDto update(Integer id, RatingDto ratingDto);

    void delete(Integer id);
}
