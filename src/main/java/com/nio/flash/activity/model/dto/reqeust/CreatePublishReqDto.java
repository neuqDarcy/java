package com.nio.flash.activity.model.dto.reqeust;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreatePublishReqDto {
    private Long ownerId;
    private Long activityId;
    private String memberIds;
    private Long pgcId;
    private Long startTime;
    private Long endTime;
    private String place;
}
