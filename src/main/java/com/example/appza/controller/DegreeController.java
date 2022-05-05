package com.example.appza.controller;

import com.example.appza.model.Degree;
import com.example.appza.service.Degree.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/degree")
@RequiredArgsConstructor
public class DegreeController {
    private final DegreeService service;
    @GetMapping()
    public ResponseEntity<Page<Degree>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                       @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));

    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<Degree>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Degree> create(@RequestBody Degree degree) {
        return ResponseEntity.ok(service.create(degree));
    }

    @PutMapping("/update")
    public ResponseEntity<Degree> update(@PathVariable Long id, @RequestBody Degree degree) {
        return ResponseEntity.ok(service.update(degree));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
