package com.example.tripit.services;

import com.example.tripit.dtos.UserDto;
import com.example.tripit.persistance.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
