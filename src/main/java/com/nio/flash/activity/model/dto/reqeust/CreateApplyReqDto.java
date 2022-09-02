package com.nio.flash.activity.model.dto.reqeust;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateApplyReqDto {
    /**
     * 活动Id
     */
    private String activityId;
    /**
     * 用户Id
     */
    private String memberId;
}