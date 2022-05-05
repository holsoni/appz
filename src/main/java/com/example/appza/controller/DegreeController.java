package com.example.appza.controller;

import com.example.appza.DTO.Degree.DegreeCreateRequest;
import com.example.appza.DTO.Degree.DegreeResponse;
import com.example.appza.DTO.Degree.DegreeUpdateRequest;
import com.example.appza.model.Degree;
import com.example.appza.service.Degree.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/degree")
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService service;
    @GetMapping()
    public ResponseEntity<Page<DegreeResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                       @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<DegreeResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<DegreeResponse> create(@RequestBody DegreeCreateRequest degree) {
        return ResponseEntity.ok(service.create(degree));
    }

    @PutMapping("/update")
    public ResponseEntity<DegreeResponse> update(@PathVariable UUID id, @RequestBody DegreeUpdateRequest degree) {
        return ResponseEntity.ok(service.update(degree));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(UUID id) {
        return service.delete(id);
    }
}
