package com.example.tripit.places.controllers;

import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.services.PlacesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/places")
public class PlacesController {

    private final PlacesServiceImpl webClientService;

    @GetMapping("/nearby")
    public ResponseEntity<Mono<PlacesDTO>> getNearbyPlaces() {

        return ResponseEntity.ok(webClientService.get());
    }
}
