package ru.xpendence.persons.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.xpendence.persons.dto.AbstractDto;

import javax.persistence.EntityNotFoundException;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 17:46
 * e-mail: v.chernyshov@pflb.ru
 */
@ControllerAdvice
public class PersonsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<AbstractDto> handle(EntityNotFoundException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return ResponseEntity.ok().headers(headers).body(new AbstractDto(e.getMessage()));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AbstractDto> handle400(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return ResponseEntity.badRequest().headers(headers).body(new AbstractDto(e.getMessage()));
    }
}
