package ru.xpendence.persons.service;

import org.springframework.stereotype.Service;
import ru.xpendence.persons.dto.UserDto;
import ru.xpendence.persons.entity.User;
import ru.xpendence.persons.mapper.UserMapper;
import ru.xpendence.persons.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:56
 * e-mail: v.chernyshov@pflb.ru
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repository,
                           UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public UserDto save(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public UserDto update(UserDto dto) {
        User user = repository.findById(dto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + dto.getId() + " не найден."));
        return mapper.toDto(repository.save(mapper.toEntity(dto, user)));
    }

    @Override
    public UserDto get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + id + " не найден.")));
    }

    @Override
    public User getEntity(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь с id " + id + " не найден."));
    }

    @Override
    public List<UserDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }
}
