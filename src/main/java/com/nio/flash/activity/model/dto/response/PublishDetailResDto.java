package com.nio.flash.activity.model.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublishDetailResDto {
    private String id;
    /**
     * 活动id
     */
    private Long activityId;
    /**
     * 审核人员id
     */
    private Long staffId;
    /**
     * 状态，0-进行中,1-审核通过,2-活动结束
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 更新时间
     */
    private Long updateTime;
}
