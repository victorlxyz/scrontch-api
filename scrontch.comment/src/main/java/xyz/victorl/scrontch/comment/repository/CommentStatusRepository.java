package xyz.victorl.scrontch.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.comment.entity.CommentStatus;

public interface CommentStatusRepository extends JpaRepository<CommentStatus, Integer> {
}
