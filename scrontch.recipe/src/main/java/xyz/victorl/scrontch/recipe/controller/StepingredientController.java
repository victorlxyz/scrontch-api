package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.StepingredientDto;
import xyz.victorl.scrontch.recipe.service.StepingredientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stepingredients")
@RequiredArgsConstructor
public class StepingredientController {

    private final StepingredientService stepingredientService;

    @GetMapping
    public ResponseEntity<List<StepingredientDto>> getAllStepingredients() {
        List<StepingredientDto> stepingredients = stepingredientService.findAll();
        return ResponseEntity.ok(stepingredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StepingredientDto> getStepingredientById(@PathVariable Integer id) {
        StepingredientDto stepingredient = stepingredientService.findById(id);
        return ResponseEntity.ok(stepingredient);
    }

    @PostMapping
    public ResponseEntity<StepingredientDto> createStepingredient(@RequestBody StepingredientDto stepingredientDto) {
        StepingredientDto createdStepingredient = stepingredientService.create(stepingredientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStepingredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StepingredientDto> updateStepingredient(
            @PathVariable Integer id, @RequestBody StepingredientDto stepingredientDto) {
        StepingredientDto updatedStepingredient = stepingredientService.update(id, stepingredientDto);
        return ResponseEntity.ok(updatedStepingredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStepingredient(@PathVariable Integer id) {
        stepingredientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
