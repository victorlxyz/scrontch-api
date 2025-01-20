package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.UserDietDto;

import java.util.List;

public interface UserDietService {
    List<UserDietDto> findAll();

    UserDietDto findById(Integer id);

    UserDietDto create(UserDietDto userDietDto);

    UserDietDto update(Integer id, UserDietDto userDietDto);

    void delete(Integer id);

    List<UserDietDto> findByUserId(Integer userId);

    void deleteByUserIdAndDietId(Integer userId, Integer dietId);
}
