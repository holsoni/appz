package com.example.appza.controller;

import com.example.appza.model.Sportsmen;
import com.example.appza.model.Training;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingController {
    @GetMapping()
    public List<Training> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                  @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<Training> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Training create(@RequestBody Training training) {
        return null;
    }

    @PutMapping("/{id}")
    public Training update(@PathVariable Long id, @RequestBody Training training) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Training delete(Long id) {
        return null;
    }
}
