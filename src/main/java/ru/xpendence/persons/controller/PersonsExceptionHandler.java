package ru.xpendence.persons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 17:46
 * e-mail: v.chernyshov@pflb.ru
 */
@ControllerAdvice
public class PersonsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        return ResponseEntity.ok(e.getMessage());
    }
}
