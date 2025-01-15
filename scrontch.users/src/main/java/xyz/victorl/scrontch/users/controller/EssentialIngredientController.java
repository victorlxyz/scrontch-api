package xyz.victorl.scrontch.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.users.dto.EssentialIngredientDto;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.service.EssentialIngredientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/essentialIngredients")
@RequiredArgsConstructor
public class EssentialIngredientController {

    private final EssentialIngredientService essentialIngredientService;

    @GetMapping
    public ResponseEntity<List<EssentialIngredientDto>> getAllEssentialIngredients() {
        List<EssentialIngredientDto> essentialIngredients = essentialIngredientService.findAll();
        return ResponseEntity.ok(essentialIngredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EssentialIngredientDto> getEssentialIngredientById(@PathVariable Integer id) {
        EssentialIngredientDto essentialIngredient = essentialIngredientService.findById(id);
        return ResponseEntity.ok(essentialIngredient);
    }

    @PostMapping
    public ResponseEntity<EssentialIngredientDto> createEssentialIngredient(@RequestBody EssentialIngredientDto essentialIngredientDto) {
        EssentialIngredientDto createdEssentialIngredient = essentialIngredientService.create(essentialIngredientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEssentialIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EssentialIngredientDto> updateEssentialIngredient(
            @PathVariable Integer id, @RequestBody EssentialIngredientDto essentialIngredientDto) {
        EssentialIngredientDto updatedEssentialIngredient = essentialIngredientService.update(id, essentialIngredientDto);
        return ResponseEntity.ok(updatedEssentialIngredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEssentialIngredient(@PathVariable Integer id) {
        essentialIngredientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EssentialIngredientDto>> getEssentialIngredients(@PathVariable("userId") Integer userId) {
        List<EssentialIngredientDto> essentialIngredients = essentialIngredientService.findByUserId(userId);
        return ResponseEntity.ok(essentialIngredients);
    }
}
