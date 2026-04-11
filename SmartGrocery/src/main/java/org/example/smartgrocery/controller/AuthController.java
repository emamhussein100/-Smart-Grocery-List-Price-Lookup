package org.example.smartgrocery.controller;


import org.example.smartgrocery.dto.AuthResponse;
import org.example.smartgrocery.dto.LoginRequestDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequestDto request) {
        return authService.login(request);
    }
}
