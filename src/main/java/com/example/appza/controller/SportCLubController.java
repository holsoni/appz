package com.example.appza.controller;

import com.example.appza.model.Sport;
import com.example.appza.model.SportClub;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sportclub")
public class SportCLubController {
    @GetMapping()
    public List<SportClub> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                  @RequestParam(required = false,defaultValue = "1") Integer page){
        return null;
    }

    @GetMapping("/{id}")
    public List<SportClub> getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping()
    public SportClub create(@RequestBody SportClub sportClub) {
        return null;
    }

    @PutMapping("/{id}")
    public SportClub update(@PathVariable Long id, @RequestBody SportClub sportClub) {
        return null;
    }
    @DeleteMapping("/{id}")
    public SportClub delete(Long id) {
        return null;
    }
}
