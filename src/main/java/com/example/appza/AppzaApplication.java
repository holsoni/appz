package com.example.appza;

import com.example.appza.controller.BuildingController;
import com.example.appza.model.Building;
import com.example.appza.repository.BuildingRepository;
import com.example.appza.service.Building.BuildingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;


@SpringBootApplication

public class AppzaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppzaApplication.class, args);
    }

}
