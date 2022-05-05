package com.example.appza.controller;

import com.example.appza.DTO.SportsmenInfoDTO;
import com.example.appza.model.Sportsmen;
import com.example.appza.service.Sportsmen.SportsmenService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

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
    public ResponseEntity<Optional<SportsmenInfoDTO>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Sportsmen> create(@RequestBody Sportsmen sportsmen) {
        return ResponseEntity.ok(service.create(sportsmen));
    }

    @PutMapping("/update")
    public ResponseEntity<Sportsmen> update(@PathVariable Long id, @RequestBody Sportsmen sportsmen) {
        return ResponseEntity.ok(service.update(sportsmen));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
