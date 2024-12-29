package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.service.StepService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/steps")
@RequiredArgsConstructor
public class StepController {

    private final StepService stepService;

    @GetMapping
    public ResponseEntity<List<RecipeDto.StepDto>> getAllSteps() {
        List<RecipeDto.StepDto> steps = stepService.findAll();
        return ResponseEntity.ok(steps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDto.StepDto> getStepById(@PathVariable Integer id) {
        RecipeDto.StepDto step = stepService.findById(id);
        return ResponseEntity.ok(step);
    }

    @PostMapping
    public ResponseEntity<RecipeDto.StepDto> createStep(@RequestBody RecipeDto.StepDto stepDto) {
        RecipeDto.StepDto createdStep = stepService.create(stepDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeDto.StepDto> updateStep(
            @PathVariable Integer id, @RequestBody RecipeDto.StepDto stepDto) {
        RecipeDto.StepDto updatedStep = stepService.update(id, stepDto);
        return ResponseEntity.ok(updatedStep);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStep(@PathVariable Integer id) {
        stepService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
