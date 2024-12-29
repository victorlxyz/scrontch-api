package xyz.victorl.scrontch.shoppinglist.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.service.NonfooditemService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nonfooditems")
@RequiredArgsConstructor
public class NonfooditemController {

    private final NonfooditemService nonfooditemService;

    @GetMapping
    public ResponseEntity<List<NonfooditemDto>> getAllNonfooditems() {
        List<NonfooditemDto> nonfooditems = nonfooditemService.findAll();
        return ResponseEntity.ok(nonfooditems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NonfooditemDto> getNonfooditemById(@PathVariable Integer id) {
        NonfooditemDto nonfooditem = nonfooditemService.findById(id);
        return ResponseEntity.ok(nonfooditem);
    }

    @PostMapping
    public ResponseEntity<NonfooditemDto> createNonfooditem(@RequestBody NonfooditemDto nonfooditemDto) {
        NonfooditemDto createdNonfooditem = nonfooditemService.create(nonfooditemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNonfooditem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NonfooditemDto> updateNonfooditem(
            @PathVariable Integer id, @RequestBody NonfooditemDto nonfooditemDto) {
        NonfooditemDto updatedNonfooditem = nonfooditemService.update(id, nonfooditemDto);
        return ResponseEntity.ok(updatedNonfooditem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNonfooditem(@PathVariable Integer id) {
        nonfooditemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
