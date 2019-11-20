package ru.xpendence.persons.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:57
 * e-mail: v.chernyshov@pflb.ru
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class UserDto extends AbstractDto {

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;
    private List<String> roles;

    public UserDto(Long id,
                   String name,
                   String surname,
                   String patronymic,
                   String email,
                   String phone,
                   List<String> roles) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
}
