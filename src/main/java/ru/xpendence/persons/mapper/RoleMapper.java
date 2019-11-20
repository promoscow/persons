package ru.xpendence.persons.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.repository.RoleRepository;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:00
 * e-mail: v.chernyshov@pflb.ru
 */
@Component
public class RoleMapper implements AbstractMapper<Role, RoleDto> {

    private final RoleRepository repository;

    public RoleMapper(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role toEntity(RoleDto dto) {
        return new Role(dto.getId(), dto.getRole(), repository.getOne(dto.getId()).getUsers());
    }

    @Override
    public RoleDto toDto(Role entity) {
        return new RoleDto(entity.getId(), entity.getRole());
    }
}
