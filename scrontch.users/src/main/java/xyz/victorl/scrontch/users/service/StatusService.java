package xyz.victorl.scrontch.users.service;

import xyz.victorl.scrontch.users.dto.StatusDto;

import java.util.List;

public interface StatusService {
    List<StatusDto> findAll();

    StatusDto findById(Integer id);

    StatusDto create(StatusDto statusDto);

    StatusDto update(Integer id, StatusDto statusDto);

    void delete(Integer id);
}
