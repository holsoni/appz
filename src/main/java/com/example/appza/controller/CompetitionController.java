package com.example.appza.controller;

import com.example.appza.model.Coach;
import com.example.appza.model.Competition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/competition")
public class CompetitionController {
    @GetMapping()
    public List<Competition> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<Competition> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Competition create(@RequestBody Competition competition) {
        return null;
    }

    @PutMapping("/{id}")
    public Competition update(@PathVariable Long id, @RequestBody Competition competition) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Competition delete(Long id) {
        return null;
    }
}
