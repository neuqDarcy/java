package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Nioer;
import com.nio.flash.activity.model.dto.reqeust.NioerLoginReqDto;
import com.nio.flash.activity.model.dto.response.NioerProfileResDto;
import com.nio.flash.activity.service.NioerService;
import com.nio.flash.activity.transfer.assembler.request.NioerLoginReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.request.UserLoginReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.request.UserRegisterReqDtoAssembler;
import org.springframework.web.bind.annotation.*;

/**
 * 员工相关
 */
@RestController
@RequestMapping("/nioer")
public class NioerController {
    private NioerLoginReqDtoAssembler nioerLoginReqDtoAssembler = NioerLoginReqDtoAssembler.INSTANCE;

    public NioerController(NioerService nioerService) {
        this.nioerService = nioerService;
    }

    private NioerService nioerService;

    @GetMapping("/{id}")
    public Response<NioerProfileResDto> getNioerProfile(@PathVariable("id")Long id) {
        return Response.success();
    }

    /**
     * 员工登录
     */
    @PostMapping("/login")
    @ResultHandler
    public Response<String> login(@RequestBody NioerLoginReqDto nioerLoginReqDto){
        Nioer nioer = nioerLoginReqDtoAssembler.toEntity(nioerLoginReqDto);
        if(nioerService.login(nioer)){
            return Response.success();
        }
        return Response.failure();
    }
}
