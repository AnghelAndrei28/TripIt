package com.example.tripit.core.services;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.mappers.factory.UserFactory;
import com.example.tripit.core.persistance.Category;
import com.example.tripit.core.persistance.UserRepository;
import com.example.tripit.core.persistance.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserFactory userFactory;

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<?> saveUser(RegisterDto registerDto) {
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("Username is already exist!", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.existsByEmail(registerDto.getEmail())){
            return new ResponseEntity<>("Email is already exist!", HttpStatus.BAD_REQUEST);
        }
        userRepository.save(generateUser(registerDto));
        return new ResponseEntity<>("User is registered successfully!", HttpStatus.OK);
    }

    private User generateUser(RegisterDto registerDto) {
        return userFactory.generateUser(registerDto);
    }

    @Override
    public Long getUserId(LoginDto loginDto) {
        return userRepository.findByUsername(loginDto.getUsername()).getId();
    }

    @Override
    public List<Category> getPreferencesById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(userOptional.isEmpty()){
            return List.of();
        }
        return userOptional.get().getPreferences();
    }
}
