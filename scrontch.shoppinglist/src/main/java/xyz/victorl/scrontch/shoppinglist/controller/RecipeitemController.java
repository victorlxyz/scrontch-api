package xyz.victorl.scrontch.shoppinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.service.RecipeitemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipeitems")
@RequiredArgsConstructor
public class RecipeitemController {

    private final RecipeitemService recipeitemService;

    @GetMapping
    public ResponseEntity<List<RecipeitemDto>> getAllRecipeitems() {
        List<RecipeitemDto> recipeitems = recipeitemService.findAll();
        return ResponseEntity.ok(recipeitems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeitemDto> getRecipeitemById(@PathVariable Integer id) {
        RecipeitemDto recipeitem = recipeitemService.findById(id);
        return ResponseEntity.ok(recipeitem);
    }

    @PostMapping
    public ResponseEntity<RecipeitemDto> createRecipeitem(@RequestBody RecipeitemDto recipeitemDto) {
        RecipeitemDto createdRecipeitem = recipeitemService.create(recipeitemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipeitem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeitemDto> updateRecipeitem(
            @PathVariable Integer id, @RequestBody RecipeitemDto recipeitemDto) {
        RecipeitemDto updatedRecipeitem = recipeitemService.update(id, recipeitemDto);
        return ResponseEntity.ok(updatedRecipeitem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeitem(@PathVariable Integer id) {
        recipeitemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
