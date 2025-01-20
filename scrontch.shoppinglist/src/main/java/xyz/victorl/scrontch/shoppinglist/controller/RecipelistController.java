package xyz.victorl.scrontch.shoppinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.RecipelistDto;
import xyz.victorl.scrontch.shoppinglist.service.RecipelistService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipelists")
@RequiredArgsConstructor
public class RecipelistController {

    private final RecipelistService recipelistService;

    @GetMapping
    public ResponseEntity<List<RecipelistDto>> getAllRecipelists() {
        List<RecipelistDto> recipelists = recipelistService.findAll();
        return ResponseEntity.ok(recipelists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipelistDto> getRecipelistById(@PathVariable Integer id) {
        RecipelistDto recipelist = recipelistService.findById(id);
        return ResponseEntity.ok(recipelist);
    }

    @PostMapping
    public ResponseEntity<RecipelistDto> createRecipelist(@RequestBody RecipelistDto recipelistDto) {
        RecipelistDto createdRecipelist = recipelistService.create(recipelistDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipelist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipelistDto> updateRecipelist(
            @PathVariable Integer id, @RequestBody RecipelistDto recipelistDto) {
        RecipelistDto updatedRecipelist = recipelistService.update(id, recipelistDto);
        return ResponseEntity.ok(updatedRecipelist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipelist(@PathVariable Integer id) {
        recipelistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<RecipelistDto>> getRecipelistsByUserId(@PathVariable("userid") Integer userid) {
        List<RecipelistDto> recipelists = recipelistService.findByUserId(userid);
        return ResponseEntity.ok(recipelists);
    }

    @PostMapping("/{id}/recipeitems")
    public ResponseEntity<RecipeitemDto> addRecipeitemToRecipelist(
            @PathVariable("id") Integer recipelistId,
            @RequestBody RecipeitemDto recipeitemDto) {
        RecipeitemDto createdRecipeItem = recipelistService.addRecipeItemToRecipelist(recipelistId, recipeitemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecipeItem);
    }

}
