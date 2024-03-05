package com.example.tripit.core.services;

import com.example.tripit.core.persistance.Category;

import java.util.List;

public interface CategoryService {
    void updateCategories();

    List<Category> getAllCategories();
}
