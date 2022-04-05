package com.example.appza.controller;

import com.example.appza.model.Degree;
import com.example.appza.model.Sport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {
    @GetMapping()
    public List<Sport> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<Sport> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Sport create(@RequestBody Sport sport) {
        return null;
    }

    @PutMapping("/{id}")
    public Sport update(@PathVariable Long id, @RequestBody Sport sport) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Sport delete(Long id) {
        return null;
    }
}
