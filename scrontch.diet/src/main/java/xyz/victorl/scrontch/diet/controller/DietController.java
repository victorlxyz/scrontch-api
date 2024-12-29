package xyz.victorl.scrontch.diet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.diet.dto.DietDto;
import xyz.victorl.scrontch.diet.service.DietService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/diets")
@RequiredArgsConstructor
public class DietController {

    private final DietService dietService;

    @GetMapping
    public ResponseEntity<List<DietDto>> getAllDiets() {
        List<DietDto> diets = dietService.findAll();
        return ResponseEntity.ok(diets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DietDto> getDietById(@PathVariable Integer id) {
        DietDto diet = dietService.findById(id);
        return ResponseEntity.ok(diet);
    }

    @PostMapping
    public ResponseEntity<DietDto> createDiet(@RequestBody DietDto dietDto) {
        DietDto createdDiet = dietService.create(dietDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDiet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DietDto> updateDiet(
            @PathVariable Integer id, @RequestBody DietDto dietDto) {
        DietDto updatedDiet = dietService.update(id, dietDto);
        return ResponseEntity.ok(updatedDiet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiet(@PathVariable Integer id) {
        dietService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
