package ru.xpendence.persons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto extends AbstractDto {

    private String name;
    private String surname;
    private String patronymic;
    private String email;
    private String phone;

    @Null
    private List<RoleDto> roles;
    private List<Long> roleIds;

    public UserDto(Long id,
                   String name,
                   String surname,
                   String patronymic,
                   String email,
                   String phone,
                   List<RoleDto> roles) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
    }
}
