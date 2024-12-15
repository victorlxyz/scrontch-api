package xyz.victorl.scrontch.ingredient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;
import xyz.victorl.scrontch.ingredient.service.IngredientSubstituteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientSubstitutes")
@RequiredArgsConstructor
public class IngredientSubstituteController {

    private final IngredientSubstituteService ingredientSubstituteService;

    @GetMapping
    public ResponseEntity<List<IngredientSubstituteDto>> getAllIngredientSubstitutes() {
        List<IngredientSubstituteDto> ingredientSubstitutes = ingredientSubstituteService.findAll();
        return ResponseEntity.ok(ingredientSubstitutes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientSubstituteDto> getIngredientSubstituteById(@PathVariable Integer id) {
        IngredientSubstituteDto ingredientSubstitute = ingredientSubstituteService.findById(id);
        return ResponseEntity.ok(ingredientSubstitute);
    }

    @PostMapping
    public ResponseEntity<IngredientSubstituteDto> createIngredientSubstitute(@RequestBody IngredientSubstituteDto ingredientSubstituteDto) {
        IngredientSubstituteDto createdIngredientSubstitute = ingredientSubstituteService.create(ingredientSubstituteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredientSubstitute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientSubstituteDto> updateIngredientSubstitute(
            @PathVariable Integer id, @RequestBody IngredientSubstituteDto ingredientSubstituteDto) {
        IngredientSubstituteDto updatedIngredientSubstitute = ingredientSubstituteService.update(id, ingredientSubstituteDto);
        return ResponseEntity.ok(updatedIngredientSubstitute);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientSubstitute(@PathVariable Integer id) {
        ingredientSubstituteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
