package com.example.appza.controller;

import com.example.appza.model.Training;
import com.example.appza.service.Training.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService service;
    @GetMapping()
    public ResponseEntity<Page<Training>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                         @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Training>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Training> create(@RequestBody Training training) {
        return ResponseEntity.ok(service.create(training));
    }

    @PutMapping("/update")
    public ResponseEntity<Training> update(@RequestBody Training training) {
        return ResponseEntity.ok(service.update(training));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
