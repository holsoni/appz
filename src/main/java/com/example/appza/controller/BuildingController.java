package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/building")
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService service;

    @GetMapping()
    public ResponseEntity<Page<Building>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/{id}")
    public List<Building> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Building create(@RequestBody Building building) {
        return null;
    }

    @PutMapping("/{id}")
    public Building update(@PathVariable Long id, @RequestBody Building building) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Building delete(Long id) {
        return null;
    }
}
