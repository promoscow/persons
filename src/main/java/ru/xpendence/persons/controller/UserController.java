package ru.xpendence.persons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.persons.dto.UserDto;
import ru.xpendence.persons.service.UserService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 20.11.19
 * Time: 15:53
 * e-mail: v.chernyshov@pflb.ru
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto) {
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping
    public ResponseEntity<UserDto> get(@RequestParam Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestParam Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}
