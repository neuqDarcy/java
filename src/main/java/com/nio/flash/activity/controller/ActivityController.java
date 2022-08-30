package com.nio.flash.activity.controller;

import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.model.dto.reqeust.CreateActivityReqDto;
import com.nio.flash.activity.model.dto.response.ActivityDetailResDto;
import com.nio.flash.activity.model.dto.response.ActivityListResDto;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("")
    public Response<String> createActivity(@RequestBody CreateActivityReqDto activityReqDto) {
        return Response.success();
    }
}
