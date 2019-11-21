package ru.xpendence.persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.persons.entity.Role;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:50
 * e-mail: v.chernyshov@pflb.ru
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findAllByRoleIn(List<String> roles);

    List<Role> findAllByIdIn(List<Long> ids);
}
