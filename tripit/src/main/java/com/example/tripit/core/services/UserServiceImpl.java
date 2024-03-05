package com.example.tripit.core.services;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.mappers.factory.UserFactory;
import com.example.tripit.core.persistance.models.Category;
import com.example.tripit.core.persistance.repositories.UserRepository;
import com.example.tripit.core.persistance.models.User;
import com.example.tripit.exceptions.CredentialsAlreadyExistException;
import com.example.tripit.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserFactory userFactory;

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new CredentialsAlreadyExistException("Username is already exist!");
        }
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new CredentialsAlreadyExistException("Email is already exist!");
        }
        userRepository.save(generateUser(registerDto));
        return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
    }

    private User generateUser(RegisterDto registerDto) {
        return userFactory.generateUser(registerDto);
    }

    @Override
    public Long getUserId(LoginDto loginDto) {
        return userRepository.findByUsername(loginDto.getUsername())
                .map(User::getId)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }

    @Override
    public List<Category> getPreferencesById(Long id) {
        return userRepository.findById(id)
                .map(User::getPreferences)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
    }
}
