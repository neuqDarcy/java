package com.nio.flash.activity.model.dto.reqeust;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateActivityReqDto {
    /**
     * 申请人ID
     */
    @NotNull(message = "owner_id is null")
    private long ownerId;
    /**
     * 活动名称
     */
    @NotBlank(message = "name is blank")
    private String name;
    /**
     * 活动简介
     */
    private String descr;
    /**
     * 头像/封面Url
     */
    private String coverUrl;
    /**
     * 帖子id
     */
    private long pgcId;
    /**
     * 活动地点
     */
    private String place;
    /**
     * 活动开始时间
     */
    @NotNull(message = "start_time is null")
    private long startTime;
    /**
     * 活动结束时间
     */
    @NotNull(message = "end_time is null")
    private long endTime;
}
