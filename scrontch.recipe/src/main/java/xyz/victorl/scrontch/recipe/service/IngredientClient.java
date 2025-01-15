package xyz.victorl.scrontch.recipe.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xyz.victorl.scrontch.common.dto.IngredientDto;

@FeignClient(name = "ingredient-service", url = "http://localhost:8083")
public interface IngredientClient {
    @GetMapping("/ingredients/{id}")
    IngredientDto getIngredientById(@PathVariable Integer id);
}
