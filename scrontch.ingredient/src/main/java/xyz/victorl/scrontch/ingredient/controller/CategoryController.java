package xyz.victorl.scrontch.ingredient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.ingredient.dto.CategoryDto;
import xyz.victorl.scrontch.ingredient.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer id) {
        CategoryDto category = categoryService.findById(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = categoryService.create(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategory = categoryService.update(id, categoryDto);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
