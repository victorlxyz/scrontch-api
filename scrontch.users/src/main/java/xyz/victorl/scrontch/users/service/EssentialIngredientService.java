package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.EssentialIngredientDto;
import xyz.victorl.scrontch.users.dto.UserDietDto;

import java.util.List;

public interface EssentialIngredientService {

    List<EssentialIngredientDto> findAll();

    EssentialIngredientDto findById(Integer id);

    EssentialIngredientDto create(EssentialIngredientDto essentialIngredientDto);

    EssentialIngredientDto update(Integer id, EssentialIngredientDto essentialIngredientDto);

    void delete(Integer id);

    List<EssentialIngredientDto> findByUserId(Integer userId);

    void deleteByUserIdAndIngredientId(Integer userId, Integer ingredientId);
}
