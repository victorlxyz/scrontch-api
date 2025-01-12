package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.dto.UserFavoriteDto;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserDiet;
import xyz.victorl.scrontch.users.entity.UserFavorite;
import xyz.victorl.scrontch.users.mapper.UserFavoriteMapper;
import xyz.victorl.scrontch.users.repository.UserFavoriteRepository;
import xyz.victorl.scrontch.users.repository.UserRepository;
import xyz.victorl.scrontch.users.service.UserFavoriteService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserFavoriteServiceImpl implements UserFavoriteService {

    private final UserFavoriteRepository userFavoriteRepository;
    private final UserFavoriteMapper userFavoriteMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserFavoriteDto> findAll() {
        return userFavoriteRepository.findAll()
                .stream()
                .map(userFavoriteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserFavoriteDto findById(Integer id) {
        UserFavorite userFavorite = userFavoriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserFavorite not found"));
        return userFavoriteMapper.toDto(userFavorite);
    }

    @Override
    public UserFavoriteDto create(UserFavoriteDto userFavoriteDto) {
        User user = userRepository.findById(userFavoriteDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setRecipeid(userFavoriteDto.getRecipeid());
        userFavorite.setUserid(user);

        return userFavoriteMapper.toDto(userFavoriteRepository.save(userFavorite));
    }

    @Override
    public UserFavoriteDto update(Integer id, UserFavoriteDto userFavoriteDto) {
        UserFavorite userFavorite = userFavoriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserFavorite not found"));

        userFavorite.setRecipeid(userFavoriteDto.getRecipeid());

        User user = userRepository.findById(userFavoriteDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userFavorite.setUserid(user);

        return userFavoriteMapper.toDto(userFavoriteRepository.save(userFavorite));
    }

    @Override
    public void delete(Integer id) {
        if (!userFavoriteRepository.existsById(id)) {
            throw new RuntimeException("UserFavorite not found");
        }
        userFavoriteRepository.deleteById(id);
    }

    @Override
    public List<UserFavoriteDto> findByUserId(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Fetch the UserDiet records for that user
        List<UserFavorite> userFavorites = userFavoriteRepository.findByUserid(user);

        // Map the UserDiet entities to DTOs
        return userFavorites.stream()
                .map(userFavoriteMapper::toDto)
                .collect(Collectors.toList());
    }
}
