package com.capstone_be.services;

import com.capstone_be.configuration.payload.LoginDto;
import com.capstone_be.configuration.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}