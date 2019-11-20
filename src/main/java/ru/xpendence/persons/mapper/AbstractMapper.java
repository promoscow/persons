package ru.xpendence.persons.mapper;

import ru.xpendence.persons.dto.AbstractDto;
import ru.xpendence.persons.entity.AbstractEntity;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:00
 * e-mail: v.chernyshov@pflb.ru
 */
public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);

    D toDto(E entity);
}
