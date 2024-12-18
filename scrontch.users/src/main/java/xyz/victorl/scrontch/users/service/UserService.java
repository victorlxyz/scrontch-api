package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto create(UserDto userDto);

    UserDto update(Integer id, UserDto userDto);

    void delete(Integer id);
}
