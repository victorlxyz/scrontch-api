package xyz.victorl.scrontch.shoppinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.shoppinglist.service.IngredientitemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredientitems")
@RequiredArgsConstructor
public class IngredientitemController {

    private final IngredientitemService ingredientitemService;

    @GetMapping
    public ResponseEntity<List<IngredientitemDto>> getAllIngredientitems() {
        List<IngredientitemDto> ingredientitems = ingredientitemService.findAll();
        return ResponseEntity.ok(ingredientitems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredientitemDto> getIngredientitemById(@PathVariable Integer id) {
        IngredientitemDto ingredientitem = ingredientitemService.findById(id);
        return ResponseEntity.ok(ingredientitem);
    }

    @PostMapping
    public ResponseEntity<IngredientitemDto> createIngredientitem(@RequestBody IngredientitemDto ingredientitemDto) {
        IngredientitemDto createdIngredientitem = ingredientitemService.create(ingredientitemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredientitem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredientitemDto> updateIngredientitem(
            @PathVariable Integer id, @RequestBody IngredientitemDto ingredientitemDto) {
        IngredientitemDto updatedIngredientitem = ingredientitemService.update(id, ingredientitemDto);
        return ResponseEntity.ok(updatedIngredientitem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientitem(@PathVariable Integer id) {
        ingredientitemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
