package xyz.victorl.scrontch.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.service.UserDietService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userDiets")
@RequiredArgsConstructor
public class UserDietController {

    private final UserDietService userDietService;

    @GetMapping
    public ResponseEntity<List<UserDietDto>> getAllUserDiets() {
        List<UserDietDto> userDiets = userDietService.findAll();
        return ResponseEntity.ok(userDiets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDietDto> getUserDietById(@PathVariable Integer id) {
        UserDietDto userDiet = userDietService.findById(id);
        return ResponseEntity.ok(userDiet);
    }

    @PostMapping
    public ResponseEntity<UserDietDto> createUserDiet(@RequestBody UserDietDto userDietDto) {
        UserDietDto createdUserDiet = userDietService.create(userDietDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserDiet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDietDto> updateUserDiet(
            @PathVariable Integer id, @RequestBody UserDietDto userDietDto) {
        UserDietDto updatedUserDiet = userDietService.update(id, userDietDto);
        return ResponseEntity.ok(updatedUserDiet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDiet(@PathVariable Integer id) {
        userDietService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserDietDto>> getUserDiets(@PathVariable("userId") Integer userId) {
        List<UserDietDto> userDiets = userDietService.findByUserId(userId);
        return ResponseEntity.ok(userDiets);
    }
}
