package xyz.victorl.scrontch.ingredient.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import xyz.victorl.scrontch.ingredient.service.IngredientSubstituteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IngredientSubstituteController.class)
public class IngredientSubstituteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientSubstituteService ingredientSubstituteService;

    @Test
    public void testGetAllIngredientSubstitutes() throws Exception {
        mockMvc.perform(get("/api/v1/ingredientSubstitutes"))
                .andExpect(status().isOk());
    }
}

