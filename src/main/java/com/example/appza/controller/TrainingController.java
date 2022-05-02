package com.example.appza.controller;

import com.example.appza.model.Building;
import com.example.appza.model.Sportsmen;
import com.example.appza.model.Training;
import com.example.appza.service.BuildingService;
import com.example.appza.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService service;
    @GetMapping()
    public ResponseEntity<Page<Training>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                 @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public Training getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/create")
    public Training create(@RequestBody Training training) {
        return service.create(training);
    }

    @PutMapping("/update")
    public Training update(@RequestBody Training training) {
        return service.update(training);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
