package com.example.tripit.places.services;

import com.example.tripit.places.dtos.CategoryDTO;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.Category;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlacesServiceImpl implements PlacesService{

    private final WebClient webClient;

    @Value("${tomtom.key}")
    private String tomtomKey;

    public Mono<PlacesDTO> getAll(GeoBias geoBias) {
        String url = String.format("https://api.tomtom.com/search/2/nearbySearch/.json?key=%s&lat=%s&lon=%s", tomtomKey, geoBias.getLat(), geoBias.getLon());
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(PlacesDTO.class);
    }

    @Override
    public Mono<PlacesDTO> getAllByCategory(String category, GeoBias geoBias) {
        String url = String.format("https://api.tomtom.com/search/2/nearbySearch/.json?key=%s&lat=%s&lon=%s&category=%s", tomtomKey, geoBias.getLat(), geoBias.getLon(), category);
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(PlacesDTO.class);
    }

    @Override
    public Mono<CategoryDTO> getAllCategories() {
        String url = String.format("https://api.tomtom.com/search/2/poiCategories.json?key=%s", tomtomKey);
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(CategoryDTO.class).map(categoryDTO -> {
                    List<Category> newList = categoryDTO.getCategories().stream().filter(category -> category.getId().toString().length() == 4).toList();
                    categoryDTO.setCategories(newList);
                    return categoryDTO;
                });
    }
}
