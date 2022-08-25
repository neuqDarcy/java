package com.nio.flash.activity.service.impl;

import com.nio.flash.activity.model.dto.UserProfileDto;
import com.nio.flash.activity.model.entity.User;
import com.nio.flash.activity.service.UserService;
import com.nio.flash.activity.transfer.assembler.UserProfileAssembler;

public class UserServiceImpl implements UserService {
    UserProfileAssembler userProfileAssembler;

    public UserServiceImpl(UserProfileAssembler userProfileAssembler) {
        this.userProfileAssembler = userProfileAssembler;
    }

    @Override
    public UserProfileDto getUserProfile(long userId) {
        User user = User.builder().id(111L).name("darcy").address("aaa").build();
        return userProfileAssembler.toDto(user);
    }
}
