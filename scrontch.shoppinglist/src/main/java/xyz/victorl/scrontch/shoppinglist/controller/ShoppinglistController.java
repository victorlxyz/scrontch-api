package xyz.victorl.scrontch.shoppinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.service.ShoppinglistService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shoppinglists")
@RequiredArgsConstructor
public class ShoppinglistController {

    private final ShoppinglistService shoppinglistService;

    @GetMapping
    public ResponseEntity<List<ShoppinglistDto>> getAllShoppinglists() {
        List<ShoppinglistDto> shoppinglists = shoppinglistService.findAll();
        return ResponseEntity.ok(shoppinglists);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppinglistDto> getShoppinglistById(@PathVariable Integer id) {
        ShoppinglistDto shoppinglist = shoppinglistService.findById(id);
        return ResponseEntity.ok(shoppinglist);
    }

    @PostMapping
    public ResponseEntity<ShoppinglistDto> createShoppinglist(@RequestBody ShoppinglistDto shoppinglistDto) {
        ShoppinglistDto createdShoppinglist = shoppinglistService.create(shoppinglistDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShoppinglist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppinglistDto> updateShoppinglist(
            @PathVariable Integer id, @RequestBody ShoppinglistDto shoppinglistDto) {
        ShoppinglistDto updatedShoppinglist = shoppinglistService.update(id, shoppinglistDto);
        return ResponseEntity.ok(updatedShoppinglist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppinglist(@PathVariable Integer id) {
        shoppinglistService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<List<ShoppinglistDto>> getShoppinglistsByUserId(@PathVariable("userid") Integer userid) {
        List<ShoppinglistDto> shoppinglists = shoppinglistService.findByUserId(userid);
        return ResponseEntity.ok(shoppinglists);
    }

    @PostMapping("/{id}/ingredientitems")
    public ResponseEntity<IngredientitemDto> addIngredientToShoppinglist(
            @PathVariable("id") Integer shoppinglistId,
            @RequestBody IngredientitemDto ingredientitemDto) {
        IngredientitemDto createdIngredientItem = shoppinglistService.addIngredientToShoppinglist(shoppinglistId, ingredientitemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdIngredientItem);
    }

    @PostMapping("/{id}/nonfooditems")
    public ResponseEntity<NonfooditemDto> addNonfooditemToShoppinglist(
            @PathVariable("id") Integer shoppinglistId,
            @RequestBody NonfooditemDto nonfooditemDto) {
        NonfooditemDto createdNonFoodItem = shoppinglistService.addNonFoodItemToShoppinglist(shoppinglistId, nonfooditemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNonFoodItem);
    }

}
