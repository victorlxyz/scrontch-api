package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.StatusDto;
import xyz.victorl.scrontch.users.entity.Status;
import xyz.victorl.scrontch.users.mapper.StatusMapper;
import xyz.victorl.scrontch.users.repository.StatusRepository;
import xyz.victorl.scrontch.users.service.StatusService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    @Override
    public List<StatusDto> findAll() {
        return statusRepository.findAll()
                .stream()
                .map(statusMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StatusDto findById(Integer id) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        return statusMapper.toDto(status);
    }

    @Override
    public StatusDto create(StatusDto statusDto) {
        Status status = statusMapper.toEntity(statusDto);
        return statusMapper.toDto(statusRepository.save(status));
    }

    @Override
    public StatusDto update(Integer id, StatusDto statusDto) {
        Status status = statusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Status not found"));

        statusMapper.partialUpdate(statusDto, status);
        return statusMapper.toDto(statusRepository.save(status));
    }

    @Override
    public void delete(Integer id) {
        if (!statusRepository.existsById(id)) {
            throw new RuntimeException("Status not found");
        }
        statusRepository.deleteById(id);
    }
}
