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
}
