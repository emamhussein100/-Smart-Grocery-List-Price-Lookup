package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.MealResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalFoodApiClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public MealResponse  searchMeals(String query) {
        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + query;
        return restTemplate.getForObject(url, MealResponse.class);
    }
}
