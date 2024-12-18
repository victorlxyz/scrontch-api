package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    RoleDto findById(Integer id);

    RoleDto create(RoleDto roleDto);

    RoleDto update(Integer id, RoleDto roleDto);

    void delete(Integer id);
}
