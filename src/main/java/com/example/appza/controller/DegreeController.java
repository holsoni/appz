package com.example.appza.controller;

import com.example.appza.model.Competition;
import com.example.appza.model.Degree;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/degree")
public class DegreeController {
    @GetMapping()
    public List<Degree> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                              @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<Degree> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Degree create(@RequestBody Degree degree) {
        return null;
    }

    @PutMapping("/{id}")
    public Degree update(@PathVariable Long id, @RequestBody Degree degree) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Degree delete(Long id) {
        return null;
    }
}
