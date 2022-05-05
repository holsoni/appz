package com.example.appza.controller;

import com.example.appza.DTO.Coach.CoachCreateRequest;
import com.example.appza.DTO.Coach.CoachResponse;
import com.example.appza.DTO.Coach.CoachUpdateRequest;
import com.example.appza.model.Coach;
import com.example.appza.service.Coach.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService service;

    @GetMapping()
    public ResponseEntity<Page<CoachResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                      @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CoachResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));    }

    @PostMapping("/create")
    public ResponseEntity<CoachResponse> create(@RequestBody CoachCreateRequest coach) {
        return ResponseEntity.ok(service.create(coach));
    }

    @PutMapping("/update")
    public ResponseEntity<CoachResponse> update(@RequestBody CoachUpdateRequest coach) {
        return ResponseEntity.ok(service.update(coach));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(UUID id) {
        return service.delete(id);
    }
}
