package xyz.victorl.scrontch.ingredient.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.ingredient.dto.IngredientDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    @Test
    public void testFindAllIngredients() {
        List<IngredientDto> ingredients = ingredientService.findAll();
        assertFalse(ingredients.isEmpty());
    }
}

