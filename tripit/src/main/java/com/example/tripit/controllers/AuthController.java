package com.example.tripit.controllers;

import com.example.tripit.dtos.UserDto;
import com.example.tripit.persistance.User;
import com.example.tripit.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    // Create a new user
    @PostMapping("/register")
    public ResponseEntity createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        userService.saveUser(userDto);
        return ResponseEntity.ok().build();
    }
}
