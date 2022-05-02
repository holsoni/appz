package com.example.appza.controller;

import com.example.appza.model.Coach;
import com.example.appza.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService service;

    @GetMapping()
    public ResponseEntity<Page<Coach>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Coach getById(@PathVariable Long id) {
        return service.getById(id);    }

    @PostMapping("/create")
    public Coach create(@RequestBody Coach coach) {
        return service.create(coach);
    }

    @PutMapping("/update")
    public Coach update(@RequestBody Coach coach) {
        return service.update(coach);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
