package com.example.tripit.core.services;

import com.example.tripit.core.persistance.Category;
import com.example.tripit.places.dtos.PlacesDTO;
import com.example.tripit.places.dtos.entities.utils.GeoBias;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoreServiceFacadeImpl implements CoreServiceFacade{

    private final UserService userService;

    private final CategoryService categoryService;

    @Override
    public void updateCategories() {
        categoryService.updateCategories();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Override
    public List<Category> getPreferencesById(Long id) {
        return userService.getPreferencesById(id);
    }
}
