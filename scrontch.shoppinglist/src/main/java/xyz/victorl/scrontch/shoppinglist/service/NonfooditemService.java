package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;

import java.util.List;

public interface NonfooditemService {
    List<NonfooditemDto> findAll();

    NonfooditemDto findById(Integer id);

    NonfooditemDto create(NonfooditemDto nonfooditemDto);

    NonfooditemDto update(Integer id, NonfooditemDto nonfooditemDto);

    void delete(Integer id);
}
