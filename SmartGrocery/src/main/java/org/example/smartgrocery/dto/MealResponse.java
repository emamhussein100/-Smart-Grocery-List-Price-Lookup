package org.example.smartgrocery.dto;

import lombok.Data;

import java.util.List;

@Data
public class MealResponse {
    private List<MealDto> meals;
}
