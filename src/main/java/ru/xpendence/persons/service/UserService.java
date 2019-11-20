package ru.xpendence.persons.service;

import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.persons.dto.UserDto;
import ru.xpendence.persons.entity.User;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:56
 * e-mail: v.chernyshov@pflb.ru
 */
public interface UserService {

    @Transactional
    UserDto save(UserDto dto);

    @Transactional
    UserDto update(UserDto dto);

    @Transactional
    UserDto get(Long id);

    @Transactional
    User getEntity(Long id);

    @Transactional
    List<UserDto> getAll();

    Boolean delete(Long id);
}
