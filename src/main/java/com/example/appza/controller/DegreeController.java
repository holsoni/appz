package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Competition;
import com.example.appza.model.Degree;
import com.example.appza.service.BuildingService;
import com.example.appza.service.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degree")
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService service;
    @GetMapping()
    public ResponseEntity<Page<Degree>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                 @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));

    }

    @GetMapping("/getById/{id}")
    public Degree getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Degree create(@RequestBody Degree degree) {
        return service.create(degree);
    }

    @PutMapping("/update")
    public Degree update(@PathVariable Long id, @RequestBody Degree degree) {
        return service.update(degree);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
