package com.example.tripit.places.controllers;

import com.example.tripit.places.dtos.CategoryDTO;
import com.example.tripit.places.dtos.entities.Category;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.services.PlacesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlacesController {

    private final PlacesServiceImpl webClientService;

    @GetMapping("/nearby")
    public ResponseEntity<Mono<PlacesDTO>> getAllNearbyPlaces() {

        return ResponseEntity.ok(webClientService.getAll());
    }

    @GetMapping("/nearby/{category}")
    public ResponseEntity<Mono<PlacesDTO>> getAllNearbyPlacesByCategory(@PathVariable("category") String category) {

        return ResponseEntity.ok(webClientService.getAllByCategory(category));
    }

    @GetMapping("/categories")
    public ResponseEntity<Mono<CategoryDTO>> getAllCategories() {

        return ResponseEntity.ok(webClientService.getAllCategories());
    }
}