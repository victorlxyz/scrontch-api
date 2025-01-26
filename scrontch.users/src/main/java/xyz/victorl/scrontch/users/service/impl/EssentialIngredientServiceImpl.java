package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.EssentialIngredientDto;
import xyz.victorl.scrontch.users.entity.EssentialIngredient;
import xyz.victorl.scrontch.common.entity.User;
import xyz.victorl.scrontch.users.mapper.EssentialIngredientMapper;
import xyz.victorl.scrontch.users.repository.EssentialIngredientRepository;
import xyz.victorl.scrontch.common.repository.UserRepository;
import xyz.victorl.scrontch.users.service.EssentialIngredientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EssentialIngredientServiceImpl implements EssentialIngredientService {

    private final EssentialIngredientRepository essentialIngredientRepository;
    private final EssentialIngredientMapper essentialIngredientMapper;
    private final UserRepository userRepository;

    @Override
    public List<EssentialIngredientDto> findAll() {
        return essentialIngredientRepository.findAll()
                .stream()
                .map(essentialIngredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EssentialIngredientDto findById(Integer id) {
        EssentialIngredient essentialIngredient = essentialIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EssentialIngredient not found"));
        return essentialIngredientMapper.toDto(essentialIngredient);
    }

    @Override
    public EssentialIngredientDto create(EssentialIngredientDto essentialIngredientDto) {
        User user = userRepository.findById(essentialIngredientDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        EssentialIngredient essentialIngredient = new EssentialIngredient();
        essentialIngredient.setIngredientid(essentialIngredientDto.getIngredientid());
        essentialIngredient.setUserid(user);
        return essentialIngredientMapper.toDto(essentialIngredientRepository.save(essentialIngredient));
    }

    @Override
    public EssentialIngredientDto update(Integer id, EssentialIngredientDto essentialIngredientDto) {
        EssentialIngredient essentialIngredient = essentialIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Essential ingredient not found"));
        essentialIngredient.setIngredientid(essentialIngredientDto.getIngredientid());
        User user = userRepository.findById(essentialIngredientDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        essentialIngredient.setUserid(user);

        return essentialIngredientMapper.toDto(essentialIngredientRepository.save(essentialIngredient));
    }

    @Override
    public void delete(Integer id) {
        if (!essentialIngredientRepository.existsById(id)) {
            throw new RuntimeException("EssentialIngredient not found");
        }
        essentialIngredientRepository.deleteById(id);
    }

    @Override
    public List<EssentialIngredientDto> findByUserId(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<EssentialIngredient> essentialIngredients = essentialIngredientRepository.findByUserid(user);

        return essentialIngredients.stream()
                .map(essentialIngredientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByUserIdAndIngredientId(Integer userId, Integer ingredientId) {
        if (!essentialIngredientRepository.existsByUserIdAndIngredientId(userId, ingredientId)) {
            throw new RuntimeException("UserIngredient not found for userId: " + userId + " and ingredientId: " + ingredientId);
        }
        essentialIngredientRepository.deleteByUserIdAndIngredientId(userId, ingredientId);
    }
}
