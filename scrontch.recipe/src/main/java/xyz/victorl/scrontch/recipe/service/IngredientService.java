package xyz.victorl.scrontch.recipe.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;

@Service
public class IngredientService {

    @Value("${ingredient.service.url}") // URL of the Ingredient Microservice
    private String ingredientServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public IngredientDto getIngredientById(Integer ingredientId) {
        String url = String.format("%s/api/v1/ingredients/%d", ingredientServiceUrl, ingredientId);
        try {
            IngredientDto ingredientDto = restTemplate.getForObject(url, IngredientDto.class);
            if (ingredientDto == null) {
                System.out.println("IngredientDto is null for ID: " + ingredientId);
            } else {
                System.out.println("Fetched IngredientDto: " + ingredientDto);
            }
            return ingredientDto;
        } catch (Exception e) {
            System.out.println("Error fetching ingredient: " + e.getMessage());
            return null; // Handle the exception as needed
        }
    }
}
