package com.example.tripit.places.services;

import com.example.tripit.places.dtos.PlacesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlacesServiceImpl implements PlacesService{

    private final WebClient webClient;

    @Value("${tomtom.key}")
    private String tomtomKey;

    public Mono<PlacesDTO> get() {
        String url = String.format("https://api.tomtom.com/search/2/nearbySearch/.json?key=%s&lat=44.448099&lon=25.982895", tomtomKey);
        return webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(PlacesDTO.class);
    }
}
