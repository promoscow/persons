package ru.xpendence.persons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:57
 * e-mail: v.chernyshov@pflb.ru
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDto implements Serializable {

    private Long id;
}
