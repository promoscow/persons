package ru.xpendence.persons.service;

import org.springframework.transaction.annotation.Transactional;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.entity.Role;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:04
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RoleService {

    @Transactional
    RoleDto save(RoleDto dto);

    @Transactional
    RoleDto update(RoleDto dto);

    @Transactional
    RoleDto get(Long id);

    @Transactional
    Role getEntity(Long id);

    @Transactional
    List<RoleDto> getAll();

    Boolean delete(Long id);
}
