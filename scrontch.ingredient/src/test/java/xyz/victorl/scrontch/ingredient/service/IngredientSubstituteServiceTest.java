package xyz.victorl.scrontch.ingredient.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.ingredient.dto.IngredientSubstituteDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class IngredientSubstituteServiceTest {

    @Autowired
    private IngredientSubstituteService ingredientSubstituteService;

    @Test
    public void testFindAllIngredientSubstitutes() {
        List<IngredientSubstituteDto> ingredientSubstitutes = ingredientSubstituteService.findAll();
        assertFalse(ingredientSubstitutes.isEmpty());
    }
}

