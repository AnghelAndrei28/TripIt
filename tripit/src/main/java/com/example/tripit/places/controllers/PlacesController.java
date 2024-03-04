package com.example.tripit.places.controllers;

import com.example.tripit.places.dtos.CategoryDTO;
import com.example.tripit.places.dtos.entities.Category;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import com.example.tripit.places.services.PlacesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlacesController {

    private final PlacesServiceImpl webClientService;

    @GetMapping("/nearby")
    public ResponseEntity<Mono<PlacesDTO>> getAllNearbyPlaces(@RequestParam("lat") double lat, @RequestParam("lon") double lon) {

        return ResponseEntity.ok(webClientService.getAll(new GeoBias(lat, lon)));
    }

    @GetMapping("/nearby/{category}")
    public ResponseEntity<Mono<PlacesDTO>> getAllNearbyPlacesByCategory(@PathVariable("category") String category, @RequestParam("lat") double lat, @RequestParam("lon") double lon) {

        return ResponseEntity.ok(webClientService.getAllByCategory(category, new GeoBias(lat, lon)));
    }

    @GetMapping("/categories")
    public ResponseEntity<Mono<CategoryDTO>> getAllCategories() {

        return ResponseEntity.ok(webClientService.getAllCategories());
    }
}
