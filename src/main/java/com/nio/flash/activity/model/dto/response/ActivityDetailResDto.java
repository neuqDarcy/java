package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActivityDetailResDto {
    private long id;
    private String name;
    private String coverUrl;
    private String place;
    private String ownerId;
    private String ownerName;
    private long startTime;
    private long endTime;
}
