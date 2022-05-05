package com.example.appza.controller;

import com.example.appza.DTO.Sportsmen.SportsmenCreateRequest;
import com.example.appza.DTO.Sportsmen.SportsmenResponse;
import com.example.appza.DTO.Sportsmen.SportsmenUpdateRequest;
import com.example.appza.model.Sportsmen;
import com.example.appza.service.Sportsmen.SportsmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sportsmen")
@RequiredArgsConstructor
public class SportsmenController {
    private final SportsmenService service;
    @GetMapping()
    public ResponseEntity<Page<SportsmenResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                          @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SportsmenResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SportsmenResponse> create(@RequestBody SportsmenCreateRequest sportsmen) {
        return ResponseEntity.ok(service.create(sportsmen));
    }

    @PutMapping("/update")
    public ResponseEntity<SportsmenResponse> update(@PathVariable UUID id, @RequestBody SportsmenUpdateRequest sportsmen) {
        return ResponseEntity.ok(service.update(sportsmen));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(UUID id) {
        return service.delete(id);
    }
}
