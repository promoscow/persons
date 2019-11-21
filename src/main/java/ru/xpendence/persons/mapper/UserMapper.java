package ru.xpendence.persons.mapper;

import org.springframework.stereotype.Component;
import ru.xpendence.persons.dto.UserDto;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.entity.User;
import ru.xpendence.persons.repository.RoleRepository;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:00
 * e-mail: v.chernyshov@pflb.ru
 */
@Component
public class UserMapper implements AbstractMapper<User, UserDto> {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public UserMapper(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public User toEntity(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getName(),
                dto.getSurname(),
                dto.getPatronymic(),
                dto.getEmail(),
                dto.getPhone(),
                getRolesByIds(dto.getRoleIds())
        );
    }

    @Override
    public User toEntity(UserDto dto, User user) {
        ifNotNull(dto.getName(), user::setName);
        ifNotNull(dto.getSurname(), user::setSurname);
        ifNotNull(dto.getPatronymic(), user::setPatronymic);
        ifNotNull(dto.getEmail(), user::setEmail);
        ifNotNull(dto.getPhone(), user::setPhone);
        user.setRoles(getRolesByIds(dto.getRoleIds()));
        return user;
    }

    @Override
    public UserDto toDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getPatronymic(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getRoles().stream().map(roleMapper::toDto).collect(Collectors.toList())
        );
    }

    private List<Role> getRolesByIds(List<Long> roles) {
        return roleRepository.findAllByIdIn(roles);
    }

    private <T> void ifNotNull(T o, Consumer<T> c) {
        if (Objects.nonNull(o)) {
            c.accept(o);
        }
    }
}
