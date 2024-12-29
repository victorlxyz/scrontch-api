package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.StepingredientDto;
import xyz.victorl.scrontch.recipe.entity.Stepingredient;
import xyz.victorl.scrontch.recipe.mapper.StepingredientMapper;
import xyz.victorl.scrontch.recipe.repository.StepingredientRepository;
import xyz.victorl.scrontch.recipe.service.StepingredientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StepingredientServiceImpl implements StepingredientService {

    private final StepingredientRepository stepingredientRepository;
    private final StepingredientMapper stepingredientMapper;

    @Override
    public List<StepingredientDto> findAll() {
        return stepingredientRepository.findAll()
                .stream()
                .map(stepingredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StepingredientDto findById(Integer id) {
        Stepingredient stepingredient = stepingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stepingredient not found"));
        return stepingredientMapper.toDto(stepingredient);
    }

    @Override
    public StepingredientDto create(StepingredientDto stepingredientDto) {
        Stepingredient stepingredient = stepingredientMapper.toEntity(stepingredientDto);
        return stepingredientMapper.toDto(stepingredientRepository.save(stepingredient));
    }

    @Override
    public StepingredientDto update(Integer id, StepingredientDto stepingredientDto) {
        Stepingredient stepingredient = stepingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stepingredient not found"));

        stepingredientMapper.partialUpdate(stepingredientDto, stepingredient);
        return stepingredientMapper.toDto(stepingredientRepository.save(stepingredient));
    }

    @Override
    public void delete(Integer id) {
        if (!stepingredientRepository.existsById(id)) {
            throw new RuntimeException("Stepingredient not found");
        }
        stepingredientRepository.deleteById(id);
    }
}
