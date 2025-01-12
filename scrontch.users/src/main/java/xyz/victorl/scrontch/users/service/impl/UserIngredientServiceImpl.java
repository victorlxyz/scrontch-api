package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.entity.UserIngredient;
import xyz.victorl.scrontch.users.mapper.UserIngredientMapper;
import xyz.victorl.scrontch.users.repository.UserIngredientRepository;
import xyz.victorl.scrontch.users.service.UserIngredientService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserIngredientServiceImpl implements UserIngredientService {

    private final UserIngredientRepository userIngredientRepository;
    private final UserIngredientMapper userIngredientMapper;

    @Override
    public List<UserIngredientDto> findAll() {
        return userIngredientRepository.findAll()
                .stream()
                .map(userIngredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserIngredientDto findById(Integer id) {
        UserIngredient userIngredient = userIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserIngredient not found"));
        return userIngredientMapper.toDto(userIngredient);
    }

    @Override
    public UserIngredientDto create(UserIngredientDto userIngredientDto) {
        UserIngredient userIngredient = userIngredientMapper.toEntity(userIngredientDto);
        return userIngredientMapper.toDto(userIngredientRepository.save(userIngredient));
    }

    @Override
    public UserIngredientDto update(Integer id, UserIngredientDto userIngredientDto) {
        UserIngredient userIngredient = userIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserIngredient not found"));

        userIngredientMapper.partialUpdate(userIngredientDto, userIngredient);
        return userIngredientMapper.toDto(userIngredientRepository.save(userIngredient));
    }

    @Override
    public void delete(Integer id) {
        if (!userIngredientRepository.existsById(id)) {
            throw new RuntimeException("UserIngredient not found");
        }
        userIngredientRepository.deleteById(id);
    }
}
