package com.example.tripit.places.dtos.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;
}
