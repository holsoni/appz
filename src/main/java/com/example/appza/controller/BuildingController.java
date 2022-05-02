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

    @GetMapping("/getAll/{size}/{page}")
    public ResponseEntity<Page<Building>> getAll(@RequestParam(required = false, defaultValue = "10") int size,
                                                @RequestParam(required = false,defaultValue = "1") int page){

        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Building getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Building create(@RequestBody Building building) {
        return service.create(building);
    }

    @PutMapping("/update")
    public Building update( @RequestBody Building building) {
        return service.update(building);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
