package xyz.victorl.scrontch.recipe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.recipe.dto.ContinentDto;
import xyz.victorl.scrontch.recipe.service.ContinentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/continents")
@RequiredArgsConstructor
public class ContinentController {

    private final ContinentService continentService;

    @GetMapping
    public ResponseEntity<List<ContinentDto>> getAllContinents() {
        List<ContinentDto> continents = continentService.findAll();
        return ResponseEntity.ok(continents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContinentDto> getContinentById(@PathVariable Integer id) {
        ContinentDto continent = continentService.findById(id);
        return ResponseEntity.ok(continent);
    }

    @PostMapping
    public ResponseEntity<ContinentDto> createContinent(@RequestBody ContinentDto continentDto) {
        ContinentDto createdContinent = continentService.create(continentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdContinent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContinentDto> updateContinent(
            @PathVariable Integer id, @RequestBody ContinentDto continentDto) {
        ContinentDto updatedContinent = continentService.update(id, continentDto);
        return ResponseEntity.ok(updatedContinent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContinent(@PathVariable Integer id) {
        continentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
