package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.RecipedietDto;
import xyz.victorl.scrontch.recipe.entity.Recipediet;
import xyz.victorl.scrontch.recipe.mapper.RecipedietMapper;
import xyz.victorl.scrontch.recipe.repository.RecipedietRepository;
import xyz.victorl.scrontch.recipe.service.RecipedietService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RecipedietServiceImpl implements RecipedietService {

    private final RecipedietRepository recipedietRepository;
    private final RecipedietMapper recipedietMapper;

    @Override
    public List<RecipedietDto> findAll() {
        return recipedietRepository.findAll()
                .stream()
                .map(recipedietMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipedietDto findById(Integer id) {
        Recipediet recipediet = recipedietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipediet not found"));
        return recipedietMapper.toDto(recipediet);
    }

    @Override
    public RecipedietDto create(RecipedietDto recipedietDto) {
        Recipediet recipediet = recipedietMapper.toEntity(recipedietDto);
        return recipedietMapper.toDto(recipedietRepository.save(recipediet));
    }

    @Override
    public RecipedietDto update(Integer id, RecipedietDto recipedietDto) {
        Recipediet recipediet = recipedietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipediet not found"));

        recipedietMapper.partialUpdate(recipedietDto, recipediet);
        return recipedietMapper.toDto(recipedietRepository.save(recipediet));
    }

    @Override
    public void delete(Integer id) {
        if (!recipedietRepository.existsById(id)) {
            throw new RuntimeException("Recipediet not found");
        }
        recipedietRepository.deleteById(id);
    }
}
