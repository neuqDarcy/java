package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.domain.Apply;
import com.nio.flash.activity.model.dto.reqeust.CreateActivityReqDto;
import com.nio.flash.activity.model.dto.reqeust.CreateApplyReqDto;
import com.nio.flash.activity.model.dto.response.ActivityBriefResDto;
import com.nio.flash.activity.model.dto.response.ActivityDetailResDto;
import com.nio.flash.activity.model.dto.response.ApplyMemberResDto;
import com.nio.flash.activity.service.ActivityService;
import com.nio.flash.activity.transfer.assembler.request.CreateActivityReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.request.CreateApplyReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.ActivitiesBriefResDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.ActivityDetailResDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.ApplyMembersResDtoAssembler;
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
    private static final CreateApplyReqDtoAssembler CREATE_APPLY_REQ_DTO_ASSEMBLER = CreateApplyReqDtoAssembler.INSTANCE;
    private static final ApplyMembersResDtoAssembler APPLY_MEMBERS_RES_DTO_ASSEMBLER = ApplyMembersResDtoAssembler.INSTANCE;
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
        List<Apply> applyMembers = activityService.getApplyMembers(activity.getId());
        List<ApplyMemberResDto> applyMemberResDtos = APPLY_MEMBERS_RES_DTO_ASSEMBLER.toDtoList(applyMembers);
        ActivityDetailResDto data = ACTIVITY_DETAIL_RES_DTO_ASSEMBLER.toDto(activity);
        data.setMembers(applyMemberResDtos);
        data.setTotalMember(applyMemberResDtos.size());
        return Response.success(data);
    }

    /**
     * 创建活动
     */
    @PostMapping
    @ResultHandler
    public Response<String> create(@RequestBody @Validated CreateActivityReqDto activityReqDto) {
        Activity activity = CREATE_ACTIVITY_REQ_DTO_ASSEMBLER.toEntity(activityReqDto);
        return Response.success(activityService.save(activity).toString());
    }

    /**
     * 报名活动
     */
    @PostMapping("/apply")
    @ResultHandler
    public Response<Boolean> apply(@RequestBody CreateApplyReqDto applyReqDto) {
        Apply apply = CREATE_APPLY_REQ_DTO_ASSEMBLER.toEntity(applyReqDto);
        return Response.success(activityService.apply(apply));
    }
}
