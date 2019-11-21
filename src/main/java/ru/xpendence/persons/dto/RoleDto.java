package ru.xpendence.persons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 14:59
 * e-mail: v.chernyshov@pflb.ru
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto extends AbstractDto {

    private String role;

    public RoleDto(Long id, String role) {
        super(id);
        this.role = role;
    }
}
