package com.example.tripit.core.services;

import com.example.tripit.core.persistance.Category;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CoreServiceFacade {

    void updateCategories();

    List<Category> getAllCategories();

    List<Category> getPreferencesById(Long id);
}
