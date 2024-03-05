package com.example.tripit.core.mappers.factory;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.persistance.*;
import com.example.tripit.places.dtos.entities.utils.CategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFactoryImpl implements UserFactory{

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    private final CategoryRepository categoryRepository;

    @Override
    public User generateUser(RegisterDto registerDto) {
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        Role roles = roleRepository.findByName("User").get();
        user.setRoles(Collections.singleton(roles));
        List<Category> preferences = categoryRepository.findAllCategoriesById(registerDto.getPreferences().stream().map(CategoryId::getId).toList());
        user.setPreferences(preferences);
        return user;
    }

    @Override
    public Long generateId(LoginDto loginDto) {
        return null;
    }
}
