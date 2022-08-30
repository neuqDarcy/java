package com.nio.flash.activity.model.dto.reqeust;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ModifyPublishReqDto {
    @NotNull(message = "activity_id not null")
    private String activityId;
    private Long staffId;
    private Integer status;
}
