package ru.xpendence.persons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.persons.dto.RoleDto;
import ru.xpendence.persons.dto.validation.Validation;
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

    @PostMapping
    public ResponseEntity<RoleDto> save(@Validated({Validation.Create.class}) @RequestBody RoleDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<RoleDto> update(@Validated({Validation.Update.class}) @RequestBody RoleDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping
    public ResponseEntity<RoleDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RoleDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
