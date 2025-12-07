package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.auth.UserProfileResponse;
import com.harshilInfotech.vibeCoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {



    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}
