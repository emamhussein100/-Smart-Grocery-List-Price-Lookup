package org.example.smartgrocery.mapper;

import org.example.smartgrocery.dto.AddUserDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.entity.User;
import org.example.smartgrocery.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserMapper {

    private final ShoppingListMapper shoppingListMapper;

    @Autowired
    public UserMapper(ShoppingListMapper shoppingListMapper) {
        this.shoppingListMapper = shoppingListMapper;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().toString());
        return userDto;
    }
    public User toUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getUserId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.valueOf(userDto.getRole()));
        return user;
    }
    public User toAddUser(AddUserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        return user;
    }
}
