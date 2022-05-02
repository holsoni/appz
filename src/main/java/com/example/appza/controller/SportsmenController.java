package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Sport;
import com.example.appza.model.Sportsmen;
import com.example.appza.service.BuildingService;
import com.example.appza.service.SportsmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sportsmen")
@RequiredArgsConstructor
public class SportsmenController {
    private final SportsmenService service;
    @GetMapping()
    public ResponseEntity<Page<Sportsmen>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                 @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Sportsmen getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Sportsmen create(@RequestBody Sportsmen sportsmen) {
        return service.create(sportsmen);
    }

    @PutMapping("/update")
    public Sportsmen update(@PathVariable Long id, @RequestBody Sportsmen sportsmen) {
        return service.update(sportsmen);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
