package com.example.tripit.core.services;

import com.example.tripit.places.dtos.CategoryDTO;
import com.example.tripit.core.persistance.Category;
import com.example.tripit.core.persistance.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final WebClient webClient;

    @Value("${tomtom.key}")
    private String tomtomKey;

    @Override
    public void updateCategories() {
        String url = String.format("https://api.tomtom.com/search/2/poiCategories.json?key=%s", tomtomKey);
        webClient.method(HttpMethod.GET)
                .uri(url)
                .retrieve()
                .bodyToMono(CategoryDTO.class).subscribe(categoryDTO -> {
                    List<Category> newList = categoryDTO.getCategories().stream().filter(category -> category.getId().toString().length() == 4).toList();
                    categoryRepository.saveAll(newList);
                });
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
