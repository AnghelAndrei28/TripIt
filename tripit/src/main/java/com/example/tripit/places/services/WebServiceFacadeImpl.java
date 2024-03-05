package com.example.tripit.places.services;

import com.example.tripit.core.services.CategoryService;
import com.example.tripit.core.services.CoreServiceFacade;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import com.example.tripit.core.persistance.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WebServiceFacadeImpl implements WebServiceFacade{

    private final PlacesService placesService;

    private final CategoryService categoryService;

    private final CoreServiceFacade coreServiceFacade;

    @Override
    public void updateCategories() {
        categoryService.updateCategories();
    }

    @Override
    public Mono<PlacesDTO> getAllPlaces(GeoBias geoBias) {
        return placesService.getAllPlaces(geoBias);
    }

    @Override
    public Mono<PlacesDTO> getAllPlacesByCategory(String category, GeoBias geoBias) {
        return placesService.getAllByCategory(category, geoBias);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public Mono<PlacesDTO> getRecommendations(Long id, GeoBias geoBias) {
        return placesService.getRecommendations(coreServiceFacade.getPreferencesById(id), geoBias);
    }
}
