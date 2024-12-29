package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.TypeDto;
import xyz.victorl.scrontch.recipe.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/types")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeDto>> getAllTypes() {
        List<TypeDto> types = typeService.findAll();
        return ResponseEntity.ok(types);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDto> getTypeById(@PathVariable Integer id) {
        TypeDto type = typeService.findById(id);
        return ResponseEntity.ok(type);
    }

    @PostMapping
    public ResponseEntity<TypeDto> createType(@RequestBody TypeDto typeDto) {
        TypeDto createdType = typeService.create(typeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDto> updateType(
            @PathVariable Integer id, @RequestBody TypeDto typeDto) {
        TypeDto updatedType = typeService.update(id, typeDto);
        return ResponseEntity.ok(updatedType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Integer id) {
        typeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
