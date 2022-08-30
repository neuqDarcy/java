package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublishDetailResDto {
    private String id;
    private Long activityId;
    private Long staffId;
    private Integer status;
    private Long createTime;
    private Long updateTime;
}
