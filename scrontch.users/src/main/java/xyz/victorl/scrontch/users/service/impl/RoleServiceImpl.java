package xyz.victorl.scrontch.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.users.dto.RoleDto;
import xyz.victorl.scrontch.users.entity.Role;
import xyz.victorl.scrontch.users.mapper.RoleMapper;
import xyz.victorl.scrontch.users.repository.RoleRepository;
import xyz.victorl.scrontch.users.service.RoleService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Integer id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return roleMapper.toDto(role);
    }

    @Override
    public RoleDto create(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public RoleDto update(Integer id, RoleDto roleDto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        roleMapper.partialUpdate(roleDto, role);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public void delete(Integer id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found");
        }
        roleRepository.deleteById(id);
    }
}
