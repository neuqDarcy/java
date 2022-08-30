package com.nio.flash.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publish {
    private Long id;
    private Long activityId;
    private Long ownerId;
    private String memberIds;
    private Long pgcId;
    private Long startTime;
    private Long endTime;
    private String place;
    private String comments;
    private Integer stars;
    private Integer status;
    private Long createTime;
    private Long updateTime;
}
