package com.nio.flash.activity.model.dto.reqeust;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateActivityReqDto {
    /**
     * 申请人ID
     */
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
    private long startTime;
    /**
     * 活动结束时间
     */
    private long endTime;
}
