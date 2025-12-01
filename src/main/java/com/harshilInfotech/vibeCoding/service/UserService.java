package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);

}
