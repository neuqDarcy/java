package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Nioer;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.reqeust.UserLoginReqDto;
import com.nio.flash.activity.model.dto.reqeust.UserRegisterReqDto;
import com.nio.flash.activity.model.dto.response.UserProfileResDto;
import com.nio.flash.activity.service.NioerService;
import com.nio.flash.activity.service.UserService;
import com.nio.flash.activity.transfer.assembler.request.UserLoginReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.request.UserRegisterReqDtoAssembler;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private UserRegisterReqDtoAssembler userRegisterReqDtoAssembler = UserRegisterReqDtoAssembler.INSTANCE;
    private UserLoginReqDtoAssembler userLoginReqDtoAssembler = UserLoginReqDtoAssembler.INSTANCE;

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

    /**
     * 用户登录
     */
    @PostMapping("/login")
    @ResultHandler
    public Response<String> login(@RequestBody UserLoginReqDto userLoginReqDto){
        User user = userLoginReqDtoAssembler.toEntity(userLoginReqDto);
        if(userService.login(user)){
            return Response.success();
        }
        return Response.failure();
    }
}
