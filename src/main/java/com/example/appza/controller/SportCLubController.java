package com.example.appza.controller;

import com.example.appza.model.SportClub;
import com.example.appza.service.SportClub.SportClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/sportclub")
@RequiredArgsConstructor
public class SportCLubController {
    private final SportClubService service;

    @GetMapping()
    public ResponseEntity<Page<SportClub>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                          @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<SportClub>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SportClub> create(@RequestBody SportClub sportClub) {
        return ResponseEntity.ok(service.create(sportClub));
    }

    @PutMapping("/update")
    public ResponseEntity<SportClub>  update(@PathVariable Long id, @RequestBody SportClub sportClub) {
        return ResponseEntity.ok(service.update(sportClub));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id) {
        return service.delete(id);
    }
}
