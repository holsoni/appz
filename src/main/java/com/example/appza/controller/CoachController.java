package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Coach;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {
    @GetMapping()
    public List<Coach> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/getById/{id}")
    public List<Coach> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/create")
    public Coach create(@RequestBody Coach coach) {
        return null;
    }

    @PutMapping("/update/{id}")
    public Coach update(@PathVariable Long id, @RequestBody Coach coach) {
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public Coach delete(Long id) {
        return null;
    }
}
