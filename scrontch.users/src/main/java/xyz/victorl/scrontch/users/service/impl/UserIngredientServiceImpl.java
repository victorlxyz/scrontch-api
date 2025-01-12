package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.dto.UserIngredientDto;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserFavorite;
import xyz.victorl.scrontch.users.entity.UserIngredient;
import xyz.victorl.scrontch.users.mapper.UserIngredientMapper;
import xyz.victorl.scrontch.users.repository.UserIngredientRepository;
import xyz.victorl.scrontch.users.repository.UserRepository;
import xyz.victorl.scrontch.users.service.UserIngredientService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserIngredientServiceImpl implements UserIngredientService {

    private final UserIngredientRepository userIngredientRepository;
    private final UserIngredientMapper userIngredientMapper;
    private final UserRepository userRepository;

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
        User user = userRepository.findById(userIngredientDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserIngredient userIngredient = new UserIngredient();
        userIngredient.setIngredientid(userIngredientDto.getIngredientid());
        userIngredient.setUserid(user);
        userIngredient.setIsessential(userIngredientDto.getIsessential());

        return userIngredientMapper.toDto(userIngredientRepository.save(userIngredient));
    }

    @Override
    public UserIngredientDto update(Integer id, UserIngredientDto userIngredientDto) {
        UserIngredient userIngredient = userIngredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserIngredient not found"));

        userIngredient.setIngredientid(userIngredientDto.getIngredientid());

        User user = userRepository.findById(userIngredientDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userIngredient.setUserid(user);

        userIngredient.setIsessential(userIngredientDto.getIsessential());


        return userIngredientMapper.toDto(userIngredientRepository.save(userIngredient));
    }

    @Override
    public void delete(Integer id) {
        if (!userIngredientRepository.existsById(id)) {
            throw new RuntimeException("UserIngredient not found");
        }
        userIngredientRepository.deleteById(id);
    }

    @Override
    public List<UserIngredientDto> findByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserIngredient> userIngredients = userIngredientRepository.findByUserid(user);

        return userIngredients.stream()
                .map(userIngredientMapper::toDto)
                .collect(Collectors.toList());
    }
}
