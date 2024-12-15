package xyz.victorl.scrontch.ingredient.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.ingredient.dto.CategoryDto;
import xyz.victorl.scrontch.ingredient.entity.Category;
import xyz.victorl.scrontch.ingredient.mapper.CategoryMapper;
import xyz.victorl.scrontch.ingredient.repository.CategoryRepository;
import xyz.victorl.scrontch.ingredient.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(Integer id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryMapper.partialUpdate(categoryDto, category);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public void delete(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
