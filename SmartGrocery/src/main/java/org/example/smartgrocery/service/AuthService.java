package org.example.smartgrocery.service;

import org.example.smartgrocery.dto.AuthResponse;
import org.example.smartgrocery.dto.LoginRequestDto;
import org.example.smartgrocery.dto.UserDto;

public interface AuthService {
     AuthResponse login(LoginRequestDto loginRequestDto);
}
