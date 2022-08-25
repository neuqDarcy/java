package com.nio.flash.activity.controller;

import com.nio.flash.activity.common.Result;
import com.nio.flash.activity.model.dto.UserProfileDto;
import com.nio.flash.activity.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile/{id}")
    public Result<UserProfileDto> getProfileById(@PathVariable long userId) {
        return Result.<UserProfileDto>ok().data(userService.getUserProfile(userId)).build();
    }
}
