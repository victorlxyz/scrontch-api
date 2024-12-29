package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.PreparationmethodDto;
import xyz.victorl.scrontch.recipe.service.PreparationmethodService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/preparationmethods")
@RequiredArgsConstructor
public class PreparationmethodController {

    private final PreparationmethodService preparationmethodService;

    @GetMapping
    public ResponseEntity<List<PreparationmethodDto>> getAllPreparationmethods() {
        List<PreparationmethodDto> preparationmethods = preparationmethodService.findAll();
        return ResponseEntity.ok(preparationmethods);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreparationmethodDto> getPreparationmethodById(@PathVariable Integer id) {
        PreparationmethodDto preparationmethod = preparationmethodService.findById(id);
        return ResponseEntity.ok(preparationmethod);
    }

    @PostMapping
    public ResponseEntity<PreparationmethodDto> createPreparationmethod(@RequestBody PreparationmethodDto preparationmethodDto) {
        PreparationmethodDto createdPreparationmethod = preparationmethodService.create(preparationmethodDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPreparationmethod);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreparationmethodDto> updatePreparationmethod(
            @PathVariable Integer id, @RequestBody PreparationmethodDto preparationmethodDto) {
        PreparationmethodDto updatedPreparationmethod = preparationmethodService.update(id, preparationmethodDto);
        return ResponseEntity.ok(updatedPreparationmethod);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreparationmethod(@PathVariable Integer id) {
        preparationmethodService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
