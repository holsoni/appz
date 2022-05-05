package com.example.appza.controller;

import com.example.appza.DTO.SportClub.SportClubCreateRequest;
import com.example.appza.DTO.SportClub.SportClubResponse;
import com.example.appza.DTO.SportClub.SportClubUpdateRequest;
import com.example.appza.model.SportClub;
import com.example.appza.service.SportClub.SportClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sportclub")
@RequiredArgsConstructor
public class SportCLubController {
    private final SportClubService service;

    @GetMapping()
    public ResponseEntity<Page<SportClubResponse>> getAll(@RequestParam(required = false, defaultValue = "10") Integer size,
                                                          @RequestParam(required = false,defaultValue = "1") Integer page){
        return ResponseEntity.ok(service.getAll(page,size));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SportClubResponse> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SportClubResponse> create(@RequestBody SportClubCreateRequest sportClub) {
        return ResponseEntity.ok(service.create(sportClub));
    }

    @PutMapping("/update")
    public ResponseEntity<SportClubResponse>  update(@PathVariable UUID id, @RequestBody SportClubUpdateRequest sportClub) {
        return ResponseEntity.ok(service.update(sportClub));
    }
    @DeleteMapping("/delete/{id}")
    public String delete(UUID id) {
        return service.delete(id);
    }
}
