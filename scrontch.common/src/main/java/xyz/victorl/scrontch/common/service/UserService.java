package xyz.victorl.scrontch.common.service;

import org.springframework.security.core.userdetails.UserDetails;
import xyz.victorl.scrontch.common.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto create(UserDto userDto);

    UserDto update(Integer id, UserDto userDto);

    void delete(Integer id);

    boolean existsById(Integer id);

    UserDetails loadUserByUsername(String username); // New Method
}
