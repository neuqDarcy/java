package com.nio.flash.activity.controller;

import com.nio.flash.activity.annotation.ResultHandler;
import com.nio.flash.activity.common.Response;
import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.dto.reqeust.CreatePublishReqDto;
import com.nio.flash.activity.model.dto.reqeust.ModifyPublishReqDto;
import com.nio.flash.activity.model.dto.response.PublishDetailResDto;
import com.nio.flash.activity.service.PublishService;
import com.nio.flash.activity.transfer.assembler.request.CreatePublishReqDtoAssembler;
import com.nio.flash.activity.transfer.assembler.response.PublishResDtoAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发布活动
 */
@RestController
@RequestMapping("/publish")
public class PublishController {

    public static final CreatePublishReqDtoAssembler CREATE_PUBLISH_REQ_DTO_ASSEMBLER = CreatePublishReqDtoAssembler.INSTANCE;
    public static final PublishResDtoAssembler PUBLISH_DETAIL_RES_DTO_ASSEMBLER = PublishResDtoAssembler.INSTANCE;

    PublishService publishService;

    public PublishController(PublishService publishService) {
        this.publishService = publishService;
    }

    /**
     * 查询工单列表
     */
    @GetMapping("/list")
    public Response<List<PublishDetailResDto>> getList() {
        List<Publish> publishes = publishService.getList();
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
     */
    @PutMapping
    public Response<String> modify(@RequestBody ModifyPublishReqDto modifyPublishReqDto) {
        return Response.success();
    }

}
