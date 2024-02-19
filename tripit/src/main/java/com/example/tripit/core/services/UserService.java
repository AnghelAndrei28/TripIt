package com.example.tripit.core.services;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<?> saveUser(RegisterDto user);

    Long getUserId(LoginDto loginDto);
}
