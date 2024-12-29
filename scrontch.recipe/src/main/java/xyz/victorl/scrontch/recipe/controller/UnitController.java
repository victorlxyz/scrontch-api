package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.UnitDto;
import xyz.victorl.scrontch.recipe.service.UnitService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/units")
@RequiredArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<List<UnitDto>> getAllUnits() {
        List<UnitDto> units = unitService.findAll();
        return ResponseEntity.ok(units);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> getUnitById(@PathVariable Integer id) {
        UnitDto unit = unitService.findById(id);
        return ResponseEntity.ok(unit);
    }

    @PostMapping
    public ResponseEntity<UnitDto> createUnit(@RequestBody UnitDto unitDto) {
        UnitDto createdUnit = unitService.create(unitDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDto> updateUnit(
            @PathVariable Integer id, @RequestBody UnitDto unitDto) {
        UnitDto updatedUnit = unitService.update(id, unitDto);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Integer id) {
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
