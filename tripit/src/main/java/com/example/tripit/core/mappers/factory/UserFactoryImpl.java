package com.example.tripit.core.mappers.factory;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.persistance.Role;
import com.example.tripit.core.persistance.RoleRepository;
import com.example.tripit.core.persistance.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class UserFactoryImpl implements UserFactory{

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public User generateUser(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role roles = roleRepository.findByName("User").get();
        user.setRoles(Collections.singleton(roles));
        return user;
    }

    @Override
    public Long generateId(LoginDto loginDto) {
        return null;
    }
}
