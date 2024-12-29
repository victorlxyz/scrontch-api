package xyz.victorl.scrontch.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.victorl.scrontch.comment.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
