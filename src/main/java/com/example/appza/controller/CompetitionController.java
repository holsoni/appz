package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import com.example.appza.model.Competition;
import com.example.appza.service.BuildingService;
import com.example.appza.service.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService service;

    @GetMapping()
    public ResponseEntity<Page<Competition>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                 @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Competition getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Competition create(@RequestBody Competition competition) {
        return service.create(competition);
    }

    @PutMapping("/update")
    public Competition update(@PathVariable Long id, @RequestBody Competition competition) {
        return service.update(competition);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
