package xyz.victorl.scrontch.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.comment.dto.CommentStatusDto;
import xyz.victorl.scrontch.comment.service.StatusService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/statuses")
@RequiredArgsConstructor
public class CommentStatusController {

    private final StatusService statusService;

    @GetMapping
    public ResponseEntity<List<CommentStatusDto>> getAllStatuses() {
        List<CommentStatusDto> statuses = statusService.findAll();
        return ResponseEntity.ok(statuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentStatusDto> getStatusById(@PathVariable Integer id) {
        CommentStatusDto status = statusService.findById(id);
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<CommentStatusDto> createStatus(@RequestBody CommentStatusDto commentStatusDto) {
        CommentStatusDto createdStatus = statusService.create(commentStatusDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentStatusDto> updateStatus(
            @PathVariable Integer id, @RequestBody CommentStatusDto commentStatusDto) {
        CommentStatusDto updatedStatus = statusService.update(id, commentStatusDto);
        return ResponseEntity.ok(updatedStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        statusService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
