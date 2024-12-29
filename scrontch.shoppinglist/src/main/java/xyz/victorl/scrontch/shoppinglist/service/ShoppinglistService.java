package xyz.victorl.scrontch.shoppinglist.service;

import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;

import java.util.List;

public interface ShoppinglistService {
    List<ShoppinglistDto> findAll();

    ShoppinglistDto findById(Integer id);

    ShoppinglistDto create(ShoppinglistDto shoppinglistDto);

    ShoppinglistDto update(Integer id, ShoppinglistDto shoppinglistDto);

    void delete(Integer id);
}
