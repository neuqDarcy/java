package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;


@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActivityBriefResDto {
    private String id;
    private String name;
    private String place;
    private long startTime;
    private long endTime;
}

