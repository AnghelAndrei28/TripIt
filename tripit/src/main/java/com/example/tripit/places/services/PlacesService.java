package com.example.tripit.places.services;

import com.example.tripit.places.dtos.PlacesDTO;
import reactor.core.publisher.Mono;

public interface PlacesService {

    Mono<PlacesDTO> getAll();

    Mono<PlacesDTO> getAllByCategory(String category);
}
