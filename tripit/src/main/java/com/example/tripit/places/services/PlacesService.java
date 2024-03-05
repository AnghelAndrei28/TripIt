package com.example.tripit.places.services;

import com.example.tripit.core.persistance.models.Category;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PlacesService {

    Mono<PlacesDTO> getAllPlaces(GeoBias geoBias);

    Mono<PlacesDTO> getAllByCategory(String category, GeoBias geoBias);

    Mono<PlacesDTO> getRecommendations(List<Category> preferences, GeoBias geoBias);

    void checkIfCategoryExists(String category);
}
