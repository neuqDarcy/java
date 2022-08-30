package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.model.dto.reqeust.CreateActivityReqDto;
import com.nio.flash.activity.model.dto.response.ActivityBriefResDto;
import com.nio.flash.activity.model.dto.response.ActivityDetailResDto;
import com.nio.flash.activity.service.ActivityService;
import com.nio.flash.activity.transfer.assembler.request.CreateActivityReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.ActivitiesBriefResDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.ActivityDetailResDtoAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 活动相关
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {
    private static final CreateActivityReqDtoAssembler CREATE_ACTIVITY_REQ_DTO_ASSEMBLER = CreateActivityReqDtoAssembler.INSTANCE;
    private static final ActivitiesBriefResDtoAssembler ACTIVITIES_BRIEF_RES_DTO_ASSEMBLER = ActivitiesBriefResDtoAssembler.INSTANCE;
    private static final ActivityDetailResDtoAssembler ACTIVITY_DETAIL_RES_DTO_ASSEMBLER = ActivityDetailResDtoAssembler.INSTANCE;
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    /**
     * 查询活动列表
     */
    @GetMapping("/list")
    public Response<List<ActivityBriefResDto>> getList() {
        List<Activity> activities = activityService.getList();
        return Response.success(ACTIVITIES_BRIEF_RES_DTO_ASSEMBLER.toDtoList(activities));
    }

    /**
     * 根据id获取活动详情
     */
    @GetMapping
    public Response<ActivityDetailResDto> getDetailById(@RequestParam("id") String id) {
        Activity activity = activityService.getById(Long.valueOf(id));
        return Response.success(ACTIVITY_DETAIL_RES_DTO_ASSEMBLER.toDto(activity));
    }

    /**
     * 创建活动
     */
    @PostMapping
    @ResultHandler
    public Response<String> create(@RequestBody @Validated CreateActivityReqDto activityReqDto) {
        Activity activity = CREATE_ACTIVITY_REQ_DTO_ASSEMBLER.toEntity(activityReqDto);
        activityService.save(activity);
        return Response.success();
    }
}
