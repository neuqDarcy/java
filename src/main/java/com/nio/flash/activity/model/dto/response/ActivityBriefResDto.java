package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActivityBriefResDto {
    private String id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 活动地点
     */
    private String place;
    /**
     * 头像url
     */
    private String coverUrl;
    /**
     * 活动状态
     */
    private Integer status;
    /**
     * 活动开始时间
     */
    private long startTime;
    /**
     * 活动结束时间
     */
    private long endTime;
}

