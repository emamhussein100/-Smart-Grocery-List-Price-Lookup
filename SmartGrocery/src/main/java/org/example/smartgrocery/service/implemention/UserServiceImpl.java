package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.AddUserDto;
import org.example.smartgrocery.dto.LoginRequestDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.entity.User;
import org.example.smartgrocery.mapper.UserMapper;
import org.example.smartgrocery.repository.UserRepository;
import org.example.smartgrocery.service.UserService;
import org.example.smartgrocery.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    //private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public UserDto addUser(AddUserDto userDto) {
        User userExists = userRepository.findByUsername(userDto.getUsername());
        if(userExists != null) {
            throw new RuntimeException("User already exists with username: " + userDto.getUsername());
        }
        User userByEmail = userRepository.findByEmail(userDto.getEmail());
        if(userByEmail != null) {
            throw new RuntimeException("User already exists with email: " + userDto.getEmail());
        }
        User user = userMapper.toAddUser(userDto);
       // String encodedPassword = passwordEncoder.encode(userDto.getPassword());
        //user.setPassword(encodedPassword);
        if(user.getRole() == null) {
            user.setRole(Role.USER);
        }
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }
}
