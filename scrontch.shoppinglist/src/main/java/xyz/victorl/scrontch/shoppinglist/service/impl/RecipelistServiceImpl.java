package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.shoppinglist.dto.RecipeitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.RecipelistDto;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem;
import xyz.victorl.scrontch.shoppinglist.entity.Recipeitem;
import xyz.victorl.scrontch.shoppinglist.entity.Recipelist;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;
import xyz.victorl.scrontch.shoppinglist.mapper.RecipeitemMapper;
import xyz.victorl.scrontch.shoppinglist.mapper.RecipelistMapper;
import xyz.victorl.scrontch.shoppinglist.repository.RecipeitemRepository;
import xyz.victorl.scrontch.shoppinglist.repository.RecipelistRepository;
import xyz.victorl.scrontch.shoppinglist.service.RecipelistService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipelistServiceImpl implements RecipelistService {

    private final RecipelistRepository recipelistRepository;
    private final RecipelistMapper recipelistMapper;
    private final RecipeitemRepository recipeitemRepository;
    private final RecipeitemMapper recipeitemMapper;

    @Override
    public List<RecipelistDto> findAll() {
        return recipelistRepository.findAll()
                .stream()
                .map(recipelistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipelistDto findById(Integer id) {
        Recipelist recipelist = recipelistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipelist not found"));
        return recipelistMapper.toDto(recipelist);
    }

    @Override
    public RecipelistDto create(RecipelistDto recipelistDto) {
        Recipelist recipelist = recipelistMapper.toEntity(recipelistDto);
        return recipelistMapper.toDto(recipelistRepository.save(recipelist));
    }

    @Override
    public RecipelistDto update(Integer id, RecipelistDto recipelistDto) {
        Recipelist recipelist = recipelistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipelist not found"));

        recipelistMapper.partialUpdate(recipelistDto, recipelist);
        return recipelistMapper.toDto(recipelistRepository.save(recipelist));
    }

    @Override
    public void delete(Integer id) {
        if (!recipelistRepository.existsById(id)) {
            throw new RuntimeException("Recipelist not found");
        }
        recipelistRepository.deleteById(id);
    }

    @Override
    public List<RecipelistDto> findByUserId(Integer userid) {
        List<Recipelist> recipelists = recipelistRepository.findByUserid(userid);
        return recipelists.stream()
                .map(recipelistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeitemDto addRecipeItemToRecipelist(Integer recipelistId, RecipeitemDto recipeitemDto) {
        Recipelist recipelist = recipelistRepository.findById(recipelistId)
                .orElseThrow(() -> new RuntimeException("Recipelist not found"));
        Recipeitem recipeitem = recipeitemMapper.toEntity(recipeitemDto);
        recipeitem.setRecipelistid(recipelist);
        Recipeitem savedItem = recipeitemRepository.save(recipeitem);

        return recipeitemMapper.toDto(savedItem);
    }

}
