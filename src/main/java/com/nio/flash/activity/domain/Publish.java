package com.nio.flash.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Publish {
    private Long id;
    private Long activityId;
    private Long staffId;
    private Integer status;
    private Long createTime;
    private Long updateTime;
}
