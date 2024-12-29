package xyz.victorl.scrontch.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.comment.dto.CommentDto;
import xyz.victorl.scrontch.comment.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<CommentDto> comments = commentService.findAll();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Integer id) {
        CommentDto comment = commentService.findById(id);
        return ResponseEntity.ok(comment);
    }

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        CommentDto createdComment = commentService.create(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable Integer id, @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.update(id, commentDto);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
