package xyz.victorl.scrontch.diet.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.diet.dto.DietDto;
import xyz.victorl.scrontch.diet.entity.Diet;
import xyz.victorl.scrontch.diet.mapper.DietMapper;
import xyz.victorl.scrontch.diet.repository.DietRepository;
import xyz.victorl.scrontch.diet.service.DietService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DietServiceImpl implements DietService {

    private final DietRepository dietRepository;
    private final DietMapper dietMapper;

    @Override
    public List<DietDto> findAll() {
        return dietRepository.findAll()
                .stream()
                .map(dietMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DietDto findById(Integer id) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found"));
        return dietMapper.toDto(diet);
    }

    @Override
    public DietDto create(DietDto dietDto) {
        Diet diet = dietMapper.toEntity(dietDto);
        return dietMapper.toDto(dietRepository.save(diet));
    }

    @Override
    public DietDto update(Integer id, DietDto dietDto) {
        Diet diet = dietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Diet not found"));

        dietMapper.partialUpdate(dietDto, diet);
        return dietMapper.toDto(dietRepository.save(diet));
    }

    @Override
    public void delete(Integer id) {
        if (!dietRepository.existsById(id)) {
            throw new RuntimeException("Diet not found");
        }
        dietRepository.deleteById(id);
    }
}
