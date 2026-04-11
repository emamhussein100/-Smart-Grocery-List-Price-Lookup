package org.example.smartgrocery.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MealDto {
    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strMealThumb;
}
