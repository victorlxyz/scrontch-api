package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;
import xyz.victorl.scrontch.shoppinglist.mapper.ShoppinglistMapper;
import xyz.victorl.scrontch.shoppinglist.repository.ShoppinglistRepository;
import xyz.victorl.scrontch.shoppinglist.service.ShoppinglistService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ShoppinglistServiceImpl implements ShoppinglistService {

    private final ShoppinglistRepository shoppinglistRepository;
    private final ShoppinglistMapper shoppinglistMapper;

    @Override
    public List<ShoppinglistDto> findAll() {
        return shoppinglistRepository.findAll()
                .stream()
                .map(shoppinglistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppinglistDto findById(Integer id) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));
        return shoppinglistMapper.toDto(shoppinglist);
    }

    @Override
    public ShoppinglistDto create(ShoppinglistDto shoppinglistDto) {
        Shoppinglist shoppinglist = shoppinglistMapper.toEntity(shoppinglistDto);
        return shoppinglistMapper.toDto(shoppinglistRepository.save(shoppinglist));
    }

    @Override
    public ShoppinglistDto update(Integer id, ShoppinglistDto shoppinglistDto) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));

        shoppinglistMapper.partialUpdate(shoppinglistDto, shoppinglist);
        return shoppinglistMapper.toDto(shoppinglistRepository.save(shoppinglist));
    }

    @Override
    public void delete(Integer id) {
        if (!shoppinglistRepository.existsById(id)) {
            throw new RuntimeException("Shoppinglist not found");
        }
        shoppinglistRepository.deleteById(id);
    }

    @Override
    public List<ShoppinglistDto> findByUserId(Integer userid) {
        List<Shoppinglist> shoppinglists = shoppinglistRepository.findByUserid(userid);
        return shoppinglists.stream()
                .map(shoppinglistMapper::toDto)
                .collect(Collectors.toList());
    }
}
