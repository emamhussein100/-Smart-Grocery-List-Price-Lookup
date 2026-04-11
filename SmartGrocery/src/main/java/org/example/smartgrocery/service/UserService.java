package org.example.smartgrocery.service;

import org.example.smartgrocery.dto.AddUserDto;
import org.example.smartgrocery.dto.LoginRequestDto;
import org.example.smartgrocery.dto.UserDto;

public interface UserService {
    UserDto addUser(AddUserDto userDto);
}
