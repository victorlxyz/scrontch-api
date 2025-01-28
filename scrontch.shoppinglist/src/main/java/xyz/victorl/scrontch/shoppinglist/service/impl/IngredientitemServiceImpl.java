package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.common.entity.Ingredientitem;
import xyz.victorl.scrontch.common.entity.Shoppinglist;
import xyz.victorl.scrontch.shoppinglist.mapper.IngredientitemMapper;
import xyz.victorl.scrontch.shoppinglist.repository.IngredientitemRepository;
import xyz.victorl.scrontch.common.repository.ShoppinglistRepository;
import xyz.victorl.scrontch.shoppinglist.service.IngredientitemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class IngredientitemServiceImpl implements IngredientitemService {

    private final IngredientitemRepository ingredientitemRepository;
    private final IngredientitemMapper ingredientitemMapper;
    private final ShoppinglistRepository shoppinglistRepository;

    @Override
    public List<IngredientitemDto> findAll() {
        return ingredientitemRepository.findAll()
                .stream()
                .map(ingredientitemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientitemDto findById(Integer id) {
        Ingredientitem ingredientitem = ingredientitemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredientitem not found"));
        return ingredientitemMapper.toDto(ingredientitem);
    }

    @Override
    public IngredientitemDto create(IngredientitemDto ingredientitemDto) {
        Ingredientitem ingredientitem = ingredientitemMapper.toEntity(ingredientitemDto);
        return ingredientitemMapper.toDto(ingredientitemRepository.save(ingredientitem));
    }

    @Override
    public IngredientitemDto update(Integer id, IngredientitemDto ingredientitemDto) {
        Ingredientitem ingredientitem = ingredientitemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingredientitem not found"));

        ingredientitemMapper.partialUpdate(ingredientitemDto, ingredientitem);
        return ingredientitemMapper.toDto(ingredientitemRepository.save(ingredientitem));
    }

    @Override
    public void delete(Integer id) {
        if (!ingredientitemRepository.existsById(id)) {
            throw new RuntimeException("Ingredientitem not found");
        }
        ingredientitemRepository.deleteById(id);
    }


}
