package xyz.victorl.scrontch.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.comment.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
