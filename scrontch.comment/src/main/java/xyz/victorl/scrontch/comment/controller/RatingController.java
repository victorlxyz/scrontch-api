package xyz.victorl.scrontch.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.comment.dto.RatingDto;
import xyz.victorl.scrontch.comment.service.RatingService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        List<RatingDto> ratings = ratingService.findAll();
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable Integer id) {
        RatingDto rating = ratingService.findById(id);
        return ResponseEntity.ok(rating);
    }

    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        RatingDto createdRating = ratingService.create(ratingDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RatingDto> updateRating(
            @PathVariable Integer id, @RequestBody RatingDto ratingDto) {
        RatingDto updatedRating = ratingService.update(id, ratingDto);
        return ResponseEntity.ok(updatedRating);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable Integer id) {
        ratingService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
