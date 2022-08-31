package com.nio.flash.activity.service;

import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.response.UserProfileResDto;

public interface UserService {
    UserProfileResDto getUserProfile(long userId);

    void save(User userRegister);

    boolean login(User useLogin);
}
