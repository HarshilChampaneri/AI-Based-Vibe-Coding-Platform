package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.auth.AuthResponse;
import com.harshilInfotech.vibeCoding.dto.auth.LoginRequest;
import com.harshilInfotech.vibeCoding.dto.auth.SignupRequest;
import com.harshilInfotech.vibeCoding.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {



    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
