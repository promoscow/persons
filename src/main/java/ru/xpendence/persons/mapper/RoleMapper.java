package ru.xpendence.persons.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.repository.RoleRepository;

import java.util.Objects;
import java.util.function.Consumer;

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
        return new Role(dto.getRole());
    }

    @Override
    public Role toEntity(RoleDto dto, Role entity) {
        ifNotNull(dto.getRole(), entity::setRole);
        return entity;
    }

    @Override
    public RoleDto toDto(Role entity) {
        return new RoleDto(entity.getId(), entity.getRole());
    }

    private <T> void ifNotNull(T o, Consumer<T> c) {
        if (Objects.nonNull(o)) {
            c.accept(o);
        }
    }
}
