package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.reqeust.UserRegisterReqDto;
import com.nio.flash.activity.model.dto.response.UserProfileResDto;
import com.nio.flash.activity.service.UserService;
import com.nio.flash.activity.transfer.assembler.request.UserRegisterReqDtoAssembler;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserRegisterReqDtoAssembler userRegisterReqDtoAssembler = UserRegisterReqDtoAssembler.INSTANCE;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;

    /**
     * 根据ID查个人主页
     */
    @GetMapping("/profile/{id}")
    public Response<UserProfileResDto> getProfileById(@PathVariable("id") long id) {
        return Response.success(null);
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    @ResultHandler
    public Response<String> register(@RequestBody UserRegisterReqDto userRegisterReqDto) {
        User user = userRegisterReqDtoAssembler.toEntity(userRegisterReqDto);
        userService.save(user);
        return Response.success();
    }
}
