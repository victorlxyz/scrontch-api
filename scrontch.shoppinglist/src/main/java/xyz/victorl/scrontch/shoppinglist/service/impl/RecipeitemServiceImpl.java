package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.entity.Recipeitem;
import xyz.victorl.scrontch.shoppinglist.mapper.RecipeitemMapper;
import xyz.victorl.scrontch.shoppinglist.repository.RecipeitemRepository;
import xyz.victorl.scrontch.shoppinglist.service.RecipeitemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipeitemServiceImpl implements RecipeitemService {

    private final RecipeitemRepository recipeitemRepository;
    private final RecipeitemMapper recipeitemMapper;

    @Override
    public List<RecipeitemDto> findAll() {
        return recipeitemRepository.findAll()
                .stream()
                .map(recipeitemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeitemDto findById(Integer id) {
        Recipeitem recipeitem = recipeitemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipeitem not found"));
        return recipeitemMapper.toDto(recipeitem);
    }

    @Override
    public RecipeitemDto create(RecipeitemDto recipeitemDto) {
        Recipeitem recipeitem = recipeitemMapper.toEntity(recipeitemDto);
        return recipeitemMapper.toDto(recipeitemRepository.save(recipeitem));
    }

    @Override
    public RecipeitemDto update(Integer id, RecipeitemDto recipeitemDto) {
        Recipeitem recipeitem = recipeitemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipeitem not found"));

        recipeitemMapper.partialUpdate(recipeitemDto, recipeitem);
        return recipeitemMapper.toDto(recipeitemRepository.save(recipeitem));
    }

    @Override
    public void delete(Integer id) {
        if (!recipeitemRepository.existsById(id)) {
            throw new RuntimeException("Recipeitem not found");
        }
        recipeitemRepository.deleteById(id);
    }
}
