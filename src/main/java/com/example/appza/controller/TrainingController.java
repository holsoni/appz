package com.example.appza.controller;

import com.example.appza.DTO.Training.TrainingCreateRequest;
import com.example.appza.DTO.Training.TrainingResponse;
import com.example.appza.DTO.Training.TrainingUpdateRequest;
import com.example.appza.model.Training;
import com.example.appza.service.Training.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService service;
    @GetMapping()
    public ResponseEntity<Page<TrainingResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                         @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TrainingResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TrainingResponse> create(@RequestBody TrainingCreateRequest training) {
        return ResponseEntity.ok(service.create(training));
    }

    @PutMapping("/update")
    public ResponseEntity<TrainingResponse> update(@RequestBody TrainingUpdateRequest training) {
        return ResponseEntity.ok(service.update(training));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
