package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.AuthResponse;
import org.example.smartgrocery.dto.LoginRequestDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.entity.User;
import org.example.smartgrocery.mapper.UserMapper;
import org.example.smartgrocery.repository.UserRepository;
import org.example.smartgrocery.service.AuthService;
import org.example.smartgrocery.service.UserService;
import org.example.smartgrocery.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(UserRepository userRepository,JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponse login(LoginRequestDto request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        String token = jwtUtil.generateToken(
                user.getUsername(),
                user.getRole().name(),
                user.getId()
        );

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }
}
