package com.nio.flash.activity.controller;

import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.model.dto.response.ActivityDetailResDto;
import com.nio.flash.activity.model.dto.response.ActivityListResDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 活动相关
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @GetMapping("/list")
    public Response<ActivityListResDto> getByList() {
        return Response.success();
    }
    @GetMapping("/{id}")
    public Response<ActivityDetailResDto> getByDetail(@PathVariable("id") Long id) {
        return Response.success();
    }
}
