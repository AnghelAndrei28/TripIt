package com.example.tripit.core.services;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.persistance.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> saveUser(RegisterDto user);

    Long getUserId(LoginDto loginDto);

    List<Category> getPreferencesById(Long id);
}
