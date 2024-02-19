package com.example.tripit.core.mappers.factory;

import com.example.tripit.auth.dtos.LoginDto;
import com.example.tripit.auth.dtos.RegisterDto;
import com.example.tripit.core.persistance.User;

public interface UserFactory {

    public User generateUser(RegisterDto registerDto);

    public Long generateId(LoginDto loginDto);
}
