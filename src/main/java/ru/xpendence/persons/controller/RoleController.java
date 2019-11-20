package ru.xpendence.persons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.service.RoleService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:53
 * e-mail: v.chernyshov@pflb.ru
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
