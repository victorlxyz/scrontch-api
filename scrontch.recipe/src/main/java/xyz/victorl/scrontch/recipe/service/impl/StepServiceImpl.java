package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.RecipeDto;
import xyz.victorl.scrontch.recipe.entity.Step;
import xyz.victorl.scrontch.recipe.mapper.StepMapper;
import xyz.victorl.scrontch.recipe.repository.StepRepository;
import xyz.victorl.scrontch.recipe.service.StepService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StepServiceImpl implements StepService {

    private final StepRepository stepRepository;
    private final StepMapper stepMapper;

    @Override
    public List<RecipeDto.StepDto> findAll() {
        return stepRepository.findAll()
                .stream()
                .map(stepMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDto.StepDto findById(Integer id) {
        Step step = stepRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Step not found"));
        return stepMapper.toDto(step);
    }

    @Override
    public RecipeDto.StepDto create(RecipeDto.StepDto stepDto) {
        Step step = stepMapper.toEntity(stepDto);
        return stepMapper.toDto(stepRepository.save(step));
    }

    @Override
    public RecipeDto.StepDto update(Integer id, RecipeDto.StepDto stepDto) {
        Step step = stepRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Step not found"));

        stepMapper.partialUpdate(stepDto, step);
        return stepMapper.toDto(stepRepository.save(step));
    }

    @Override
    public void delete(Integer id) {
        if (!stepRepository.existsById(id)) {
            throw new RuntimeException("Step not found");
        }
        stepRepository.deleteById(id);
    }
}
