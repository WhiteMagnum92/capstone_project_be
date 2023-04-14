package com.capstone_be.services;

import com.capstone_be.configuration.payload.JWTAuthResponse;
import com.capstone_be.configuration.payload.LoginDto;
import com.capstone_be.configuration.payload.RegisterDto;

public interface AuthService {
    
	JWTAuthResponse login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
