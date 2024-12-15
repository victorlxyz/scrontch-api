package xyz.victorl.scrontch.ingredient.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.victorl.scrontch.ingredient.dto.CategoryDto;

import java.util.List;

import static org.junit.Assert.assertFalse;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testFindAllCategories() {
        List<CategoryDto> categories = categoryService.findAll();
        assertFalse(categories.isEmpty());
    }
}

