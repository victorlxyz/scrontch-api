package xyz.victorl.scrontch.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.service.UserIngredientService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userIngredients")
@RequiredArgsConstructor
public class UserIngredientController {

    private final UserIngredientService userIngredientService;

    @GetMapping
    public ResponseEntity<List<UserIngredientDto>> getAllUserIngredients() {
        List<UserIngredientDto> userIngredients = userIngredientService.findAll();
        return ResponseEntity.ok(userIngredients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserIngredientDto> getUserIngredientById(@PathVariable Integer id) {
        UserIngredientDto userIngredient = userIngredientService.findById(id);
        return ResponseEntity.ok(userIngredient);
    }

    @PostMapping
    public ResponseEntity<UserIngredientDto> createUserIngredient(@RequestBody UserIngredientDto userIngredientDto) {
        UserIngredientDto createdUserIngredient = userIngredientService.create(userIngredientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserIngredient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserIngredientDto> updateUserIngredient(
            @PathVariable Integer id, @RequestBody UserIngredientDto userIngredientDto) {
        UserIngredientDto updatedUserIngredient = userIngredientService.update(id, userIngredientDto);
        return ResponseEntity.ok(updatedUserIngredient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserIngredient(@PathVariable Integer id) {
        userIngredientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserIngredientDto>> getUserIngredients(@PathVariable("userId") Integer userId) {
        List<UserIngredientDto> userIngredients = userIngredientService.findByUserId(userId);
        return ResponseEntity.ok(userIngredients);
    }
}
