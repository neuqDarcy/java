package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActivityDetailResDto {
    /**
     * 活动id
     */
    private long id;
    /**
     * 活动名称
     */
    private String name;
    /**
     * 封面/头像图片ur
     */
    private String coverUrl;
    /**
     * 轮播图url
     */
    private String[] imgUrls;
    /**
     * 活动地点
     */
    private String place;
    /**
     * 活动举办人id
     */
    private String ownerId;
    /**
     * 活动举办人昵称
     */
    private String ownerName;
    /**
     * 活动开始时间
     */
    private long startTime;
    /**
     * 活动结束时间
     */
    private long endTime;
    /**
     * 报名活动的总人数
     */
    private Integer totalMember;
    private List<ApplyMemberResDto> members;
}
