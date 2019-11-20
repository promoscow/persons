package ru.xpendence.persons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.xpendence.persons.entity.User;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:50
 * e-mail: v.chernyshov@pflb.ru
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
