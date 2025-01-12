package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.UserDietDto;
import xyz.victorl.scrontch.users.entity.User;
import xyz.victorl.scrontch.users.entity.UserDiet;
import xyz.victorl.scrontch.users.mapper.UserDietMapper;
import xyz.victorl.scrontch.users.repository.UserDietRepository;
import xyz.victorl.scrontch.users.repository.UserRepository;
import xyz.victorl.scrontch.users.service.UserDietService;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDietServiceImpl implements UserDietService {

    private final UserDietRepository userDietRepository;
    private final UserDietMapper userDietMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDietDto> findAll() {
        return userDietRepository.findAll()
                .stream()
                .map(userDietMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDietDto findById(Integer id) {
        UserDiet userDiet = userDietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDiet not found"));
        return userDietMapper.toDto(userDiet);
    }

    @Override
    public UserDietDto create(UserDietDto userDietDto) {
        // Fetch the User entity using the userId (Integer)
        User user = userRepository.findById(userDietDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create the UserDiet entity and set the User object
        UserDiet userDiet = new UserDiet();
        userDiet.setDietid(userDietDto.getDietid());
        userDiet.setUserid(user); // Set the actual User entity

        // Save and return the UserDiet
        return userDietMapper.toDto(userDietRepository.save(userDiet));
    }

    @Override
    public UserDietDto update(Integer id, UserDietDto userDietDto) {
        UserDiet userDiet = userDietRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDiet not found"));

        // Update the UserDiet with the new data from DTO
        userDiet.setDietid(userDietDto.getDietid());

        // Fetch the User entity and update the relation
        User user = userRepository.findById(userDietDto.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userDiet.setUserid(user);

        return userDietMapper.toDto(userDietRepository.save(userDiet));
    }

    @Override
    public void delete(Integer id) {
        if (!userDietRepository.existsById(id)) {
            throw new RuntimeException("UserDiet not found");
        }
        userDietRepository.deleteById(id);
    }

    @Override
    public List<UserDietDto> findByUserId(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<UserDiet> userDiets = userDietRepository.findByUserid(user);

        return userDiets.stream()
                .map(userDietMapper::toDto)
                .collect(Collectors.toList());
    }
}
