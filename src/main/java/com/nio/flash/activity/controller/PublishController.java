package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.dto.reqeust.CreatePublishReqDto;
import com.nio.flash.activity.model.dto.reqeust.ModifyPublishReqDto;
import com.nio.flash.activity.model.dto.response.PublishDetailResDto;
import com.nio.flash.activity.service.PublishService;
import com.nio.flash.activity.transfer.assembler.request.CreatePublishReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.request.ModifyPublishReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.PublishResDtoAssembler;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 发布
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    public static final CreatePublishReqDtoAssembler CREATE_PUBLISH_REQ_DTO_ASSEMBLER = CreatePublishReqDtoAssembler.INSTANCE;
    public static final PublishResDtoAssembler PUBLISH_DETAIL_RES_DTO_ASSEMBLER = PublishResDtoAssembler.INSTANCE;
    public static final ModifyPublishReqDtoAssembler MODIFY_PUBLISH_REQ_DTO_ASSEMBLER = ModifyPublishReqDtoAssembler.INSTANCE;

    PublishService publishService;

    public PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    /**
     * 查询工单列表
     */
    @GetMapping("/list")
    public Response<List<PublishDetailResDto>> getList(@RequestParam(value = "status", required = false) Integer status) {
        List<Publish> publishes = publishService.getList();
        if (null != status) {
            List<Publish> publishByStatus = publishes.stream().filter(item -> item.getStatus().equals(status)).collect(Collectors.toList());
            return Response.success(PUBLISH_DETAIL_RES_DTO_ASSEMBLER.toDtoList(publishByStatus));
        }
        return Response.success(PUBLISH_DETAIL_RES_DTO_ASSEMBLER.toDtoList(publishes));
    }

    /**
     * 根据ID获取发布工单详情
     */
    @GetMapping
    public Response<PublishDetailResDto> getDetailById(@RequestParam Long id) {
        Publish publish = publishService.getDetailById(id);
        PublishDetailResDto publishDetailResDto = PUBLISH_DETAIL_RES_DTO_ASSEMBLER.toDto(publish);
        return Response.success(publishDetailResDto);
    }

    /**
     * 创建发布工单
     */
    @PostMapping
    @ResultHandler
    public Response<String> createPublish(@RequestBody CreatePublishReqDto createPublishReqDto) {
        Publish publish = CREATE_PUBLISH_REQ_DTO_ASSEMBLER.toEntity(createPublishReqDto);
        publishService.save(publish);
        return Response.success();
    }

    /**
     * 修改发布工单
     * 注意：id 必填,id 为工单id
     * 该接口应用于以下场景:
     * 1. 修改工单状态
     * 2. 当运营人员处理工单时，将staff_id改为该人员工号
     */
    @PutMapping
    @ResultHandler
    public Response<String> modify(@RequestBody @Validated ModifyPublishReqDto modifyPublishReqDto) {
        Long activityId = Long.valueOf(modifyPublishReqDto.getId());
        Publish oldItem = publishService.getDetailById(activityId);
        publishService.save(MODIFY_PUBLISH_REQ_DTO_ASSEMBLER.updateEntityFromDto(modifyPublishReqDto, oldItem));
        return Response.success();
    }

}
