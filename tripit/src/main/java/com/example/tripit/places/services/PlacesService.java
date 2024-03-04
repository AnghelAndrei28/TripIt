package com.example.tripit.places.services;

import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import reactor.core.publisher.Mono;

public interface PlacesService {

    Mono<PlacesDTO> getAllPlaces(GeoBias geoBias);

    Mono<PlacesDTO> getAllByCategory(String category, GeoBias geoBias);
}
