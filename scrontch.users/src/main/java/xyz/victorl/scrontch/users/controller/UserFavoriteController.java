package xyz.victorl.scrontch.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.service.UserFavoriteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userFavorites")
@RequiredArgsConstructor
public class UserFavoriteController {

    private final UserFavoriteService userFavoriteService;

    @GetMapping
    public ResponseEntity<List<UserFavoriteDto>> getAllUserFavorites() {
        List<UserFavoriteDto> userFavorites = userFavoriteService.findAll();
        return ResponseEntity.ok(userFavorites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFavoriteDto> getUserFavoriteById(@PathVariable Integer id) {
        UserFavoriteDto userFavorite = userFavoriteService.findById(id);
        return ResponseEntity.ok(userFavorite);
    }

    @PostMapping
    public ResponseEntity<UserFavoriteDto> createUserFavorite(@RequestBody UserFavoriteDto userFavoriteDto) {
        UserFavoriteDto createdUserFavorite = userFavoriteService.create(userFavoriteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserFavorite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserFavoriteDto> updateUserFavorite(
            @PathVariable Integer id, @RequestBody UserFavoriteDto userFavoriteDto) {
        UserFavoriteDto updatedUserFavorite = userFavoriteService.update(id, userFavoriteDto);
        return ResponseEntity.ok(updatedUserFavorite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFavorite(@PathVariable Integer id) {
        userFavoriteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserFavoriteDto>> getUserFavorites(@PathVariable("userId") Integer userId) {
        List<UserFavoriteDto> userFavorites = userFavoriteService.findByUserId(userId);
        return ResponseEntity.ok(userFavorites);
    }

    @DeleteMapping("/user/{userId}/recipe/{recipeId}")
    public ResponseEntity<Void> deleteUserFavoriteByUserIdAndRecipeId(
            @PathVariable("userId") Integer userId,
            @PathVariable("recipeId") Integer recipeId) {
        userFavoriteService.deleteByUserIdAndRecipeId(userId, recipeId);
        return ResponseEntity.noContent().build();
    }

}
