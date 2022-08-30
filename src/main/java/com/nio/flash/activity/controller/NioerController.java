package com.nio.flash.activity.controller;

import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.model.dto.response.NioerProfileResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工相关
 */
@RestController
@RequestMapping("/nioer")
public class NioerController {
    @GetMapping("/{id}")
    public Response<NioerProfileResDto> getNioerProfile(@PathVariable("id")Long id) {
        return Response.success();
    }
}
