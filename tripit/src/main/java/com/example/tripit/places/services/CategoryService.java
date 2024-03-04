package com.example.tripit.places.services;

import com.example.tripit.places.persistance.Category;

import java.util.List;

public interface CategoryService {
    void updateCategories();

    List<Category> getAllCategories();
}
