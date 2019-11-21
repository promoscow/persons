package ru.xpendence.persons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.xpendence.persons.dto.validation.Validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AbstractDto implements Serializable {

    @Null(groups = Validation.Create.class)
    @NotNull(groups = Validation.Update.class)
    private Long id;

    @Null
    private String errorMessage;

    AbstractDto(Long id) {
        this.id = id;
    }

    public AbstractDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
