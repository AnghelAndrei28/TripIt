package com.example.tripit.places.services;

import com.example.tripit.places.dtos.CategoryDTO;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.Category;
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

    public Mono<PlacesDTO> getAll() {
        String url = String.format("https://api.tomtom.com/search/2/nearbySearch/.json?key=%s&lat=44.448099&lon=25.982895", tomtomKey);
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(PlacesDTO.class);
    }

    @Override
    public Mono<PlacesDTO> getAllByCategory(String category) {
        String url = String.format("https://api.tomtom.com/search/2/nearbySearch/.json?key=%s&lat=44.448099&lon=25.982895&category=%s", tomtomKey, category);
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
