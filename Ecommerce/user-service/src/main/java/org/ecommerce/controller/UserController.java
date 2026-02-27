package org.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.dto.UserDto;
import org.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.ecommerce.constants.UserConstants.*;

@RestController
@RequestMapping(BASE_PATH)
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping(GET_USER_BY_ID)
    public ResponseEntity<UserDto> getUser(@PathVariable("id") UUID id) {
        log.info("Controller reached");
        return ResponseEntity.ok(userService.getUserById(id));
    }
}