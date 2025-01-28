package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.common.entity.Nonfooditem;
import xyz.victorl.scrontch.shoppinglist.mapper.NonfooditemMapper;
import xyz.victorl.scrontch.shoppinglist.repository.NonfooditemRepository;
import xyz.victorl.scrontch.shoppinglist.service.NonfooditemService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NonfooditemServiceImpl implements NonfooditemService {

    private final NonfooditemRepository nonfooditemRepository;
    private final NonfooditemMapper nonfooditemMapper;

    @Override
    public List<NonfooditemDto> findAll() {
        return nonfooditemRepository.findAll()
                .stream()
                .map(nonfooditemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public NonfooditemDto findById(Integer id) {
        Nonfooditem nonfooditem = nonfooditemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nonfooditem not found"));
        return nonfooditemMapper.toDto(nonfooditem);
    }

    @Override
    public NonfooditemDto create(NonfooditemDto nonfooditemDto) {
        Nonfooditem nonfooditem = nonfooditemMapper.toEntity(nonfooditemDto);
        return nonfooditemMapper.toDto(nonfooditemRepository.save(nonfooditem));
    }

    @Override
    public NonfooditemDto update(Integer id, NonfooditemDto nonfooditemDto) {
        Nonfooditem nonfooditem = nonfooditemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nonfooditem not found"));

        nonfooditemMapper.partialUpdate(nonfooditemDto, nonfooditem);
        return nonfooditemMapper.toDto(nonfooditemRepository.save(nonfooditem));
    }

    @Override
    public void delete(Integer id) {
        if (!nonfooditemRepository.existsById(id)) {
            throw new RuntimeException("Nonfooditem not found");
        }
        nonfooditemRepository.deleteById(id);
    }
}
