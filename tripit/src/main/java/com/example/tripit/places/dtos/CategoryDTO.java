package com.example.tripit.places.dtos;

import com.example.tripit.places.dtos.entities.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    @JsonProperty("poiCategories")
    private List<Category> categories;

}