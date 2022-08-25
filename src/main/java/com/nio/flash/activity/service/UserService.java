package com.nio.flash.activity.service;

import com.nio.flash.activity.model.dto.UserProfileDto;

public interface UserService {
    UserProfileDto getUserProfile(long userId);
}
