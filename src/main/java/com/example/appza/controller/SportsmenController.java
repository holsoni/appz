package com.example.appza.controller;

import com.example.appza.model.Sport;
import com.example.appza.model.Sportsmen;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sportsmen")
public class SportsmenController {
    @GetMapping()
    public List<Sportsmen> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                  @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<Sportsmen> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public Sportsmen create(@RequestBody Sportsmen sportsmen) {
        return null;
    }

    @PutMapping("/{id}")
    public Sportsmen update(@PathVariable Long id, @RequestBody Sportsmen sportsmen) {
        return null;
    }
    @DeleteMapping("/{id}")
    public Sportsmen delete(Long id) {
        return null;
    }
}
