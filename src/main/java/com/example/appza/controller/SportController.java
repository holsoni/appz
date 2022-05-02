package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import com.example.appza.service.BuildingService;
import com.example.appza.service.SportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Sport getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Sport create(@RequestBody Sport sport) {
        return service.create(sport);
    }

    @PutMapping("/update")
    public Sport update(@PathVariable Long id, @RequestBody Sport sport) {
        return service.update(sport);
    }
    @DeleteMapping("/delete/{id}")

    public String delete(Long id) {
        return service.delete(id);
    }
}
