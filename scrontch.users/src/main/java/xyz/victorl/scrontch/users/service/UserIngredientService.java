package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.UserIngredientDto;

import java.util.List;

public interface UserIngredientService {
    List<UserIngredientDto> findAll();

    UserIngredientDto findById(Integer id);

    UserIngredientDto create(UserIngredientDto userIngredientDto);

    UserIngredientDto update(Integer id, UserIngredientDto userIngredientDto);

    void delete(Integer id);

    List<UserIngredientDto> findByUserId(Integer userId);

    void deleteByUserIdAndIngredientId(Integer userId, Integer ingredientId);
}
