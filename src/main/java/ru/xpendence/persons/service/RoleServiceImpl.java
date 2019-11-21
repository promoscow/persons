package ru.xpendence.persons.service;

import org.springframework.stereotype.Service;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.mapper.RoleMapper;
import ru.xpendence.persons.repository.RoleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:21
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    public RoleServiceImpl(RoleRepository repository,
                           RoleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RoleDto save(RoleDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public RoleDto update(RoleDto dto) {
        Role role = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + dto.getId() + " не найден."));
        return mapper.toDto(repository.save(mapper.toEntity(dto, role)));
    }

    @Override
    public RoleDto get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Роль с id " + id + " не найдена.")));
    }

    @Override
    public Role getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Роль с id " + id + " не найдена."));
    }

    @Override
    public List<RoleDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }
}
