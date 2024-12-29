package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.UnitDto;
import xyz.victorl.scrontch.recipe.entity.Unit;
import xyz.victorl.scrontch.recipe.mapper.UnitMapper;
import xyz.victorl.scrontch.recipe.repository.UnitRepository;
import xyz.victorl.scrontch.recipe.service.UnitService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @Override
    public List<UnitDto> findAll() {
        return unitRepository.findAll()
                .stream()
                .map(unitMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UnitDto findById(Integer id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));
        return unitMapper.toDto(unit);
    }

    @Override
    public UnitDto create(UnitDto unitDto) {
        Unit unit = unitMapper.toEntity(unitDto);
        return unitMapper.toDto(unitRepository.save(unit));
    }

    @Override
    public UnitDto update(Integer id, UnitDto unitDto) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Unit not found"));

        unitMapper.partialUpdate(unitDto, unit);
        return unitMapper.toDto(unitRepository.save(unit));
    }

    @Override
    public void delete(Integer id) {
        if (!unitRepository.existsById(id)) {
            throw new RuntimeException("Unit not found");
        }
        unitRepository.deleteById(id);
    }
}
