package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;

import java.util.List;

public interface UserFavoriteService {
    List<UserFavoriteDto> findAll();

    UserFavoriteDto findById(Integer id);

    UserFavoriteDto create(UserFavoriteDto userFavoriteDto);

    UserFavoriteDto update(Integer id, UserFavoriteDto userFavoriteDto);

    void delete(Integer id);

    List<UserFavoriteDto> findByUserId(Integer userId);

    void deleteByUserIdAndRecipeId(Integer userId, Integer recipeId);
}
