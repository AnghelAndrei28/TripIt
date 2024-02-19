package com.example.tripit.core.services;

import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.persistance.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(RegisterDto user);
}
