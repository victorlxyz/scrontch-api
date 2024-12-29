package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.RecipedietDto;
import xyz.victorl.scrontch.recipe.service.RecipedietService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipediets")
@RequiredArgsConstructor
public class RecipedietController {

    private final RecipedietService recipedietService;

    @GetMapping
    public ResponseEntity<List<RecipedietDto>> getAllRecipediets() {
        List<RecipedietDto> recipediets = recipedietService.findAll();
        return ResponseEntity.ok(recipediets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipedietDto> getRecipedietById(@PathVariable Integer id) {
        RecipedietDto recipediet = recipedietService.findById(id);
        return ResponseEntity.ok(recipediet);
    }

    @PostMapping
    public ResponseEntity<RecipedietDto> createRecipediet(@RequestBody RecipedietDto recipedietDto) {
        RecipedietDto createdRecipediet = recipedietService.create(recipedietDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipediet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipedietDto> updateRecipediet(
            @PathVariable Integer id, @RequestBody RecipedietDto recipedietDto) {
        RecipedietDto updatedRecipediet = recipedietService.update(id, recipedietDto);
        return ResponseEntity.ok(updatedRecipediet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipediet(@PathVariable Integer id) {
        recipedietService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
