package com.example.appza.controller;

import com.example.appza.model.Sport;
import com.example.appza.service.Sport.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sport")
@RequiredArgsConstructor
public class SportController {
    private final SportService service;
    @GetMapping()
    public ResponseEntity<Page<Sport>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                      @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Sport>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Sport> create(@RequestBody Sport sport) {
        return ResponseEntity.ok(service.create(sport));
    }

    @PutMapping("/update")
    public ResponseEntity<Sport> update(@PathVariable Long id, @RequestBody Sport sport) {
        return ResponseEntity.ok(service.update(sport));
    }
    @DeleteMapping("/delete/{id}")

    public String delete(Long id) {
        return service.delete(id);
    }
}
