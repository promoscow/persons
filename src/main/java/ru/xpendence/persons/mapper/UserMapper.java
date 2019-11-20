package ru.xpendence.persons.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.xpendence.persons.dto.AbstractDto;
import ru.xpendence.persons.dto.UserDto;
import ru.xpendence.persons.entity.AbstractEntity;
import ru.xpendence.persons.entity.Role;
import ru.xpendence.persons.entity.User;
import ru.xpendence.persons.repository.RoleRepository;
import ru.xpendence.persons.repository.UserRepository;
import ru.xpendence.persons.service.RoleService;
import ru.xpendence.persons.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:00
 * e-mail: v.chernyshov@pflb.ru
 */
@Component
public class UserMapper implements AbstractMapper<User, UserDto> {

    private final UserRepository repository;
    private final RoleRepository roleRepository;

    public UserMapper(UserRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
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
                getRoles(dto.getRoles())
        );
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
                entity.getRoles().stream().map(Role::getRole).collect(Collectors.toList())
        );
    }

    private List<Role> getRoles(List<String> roles) {
        return roleRepository.findAllByRoleIn(roles);
    }
}
