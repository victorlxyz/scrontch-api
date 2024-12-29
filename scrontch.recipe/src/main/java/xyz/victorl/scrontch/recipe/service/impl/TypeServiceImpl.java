package xyz.victorl.scrontch.recipe.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.recipe.dto.TypeDto;
import xyz.victorl.scrontch.recipe.entity.Type;
import xyz.victorl.scrontch.recipe.mapper.TypeMapper;
import xyz.victorl.scrontch.recipe.repository.TypeRepository;
import xyz.victorl.scrontch.recipe.service.TypeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    @Override
    public List<TypeDto> findAll() {
        return typeRepository.findAll()
                .stream()
                .map(typeMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDto findById(Integer id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type not found"));
        return typeMapper.toDto(type);
    }

    @Override
    public TypeDto create(TypeDto typeDto) {
        Type type = typeMapper.toEntity(typeDto);
        return typeMapper.toDto(typeRepository.save(type));
    }

    @Override
    public TypeDto update(Integer id, TypeDto typeDto) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type not found"));

        typeMapper.partialUpdate(typeDto, type);
        return typeMapper.toDto(typeRepository.save(type));
    }

    @Override
    public void delete(Integer id) {
        if (!typeRepository.existsById(id)) {
            throw new RuntimeException("Type not found");
        }
        typeRepository.deleteById(id);
    }
}
