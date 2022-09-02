package com.nio.flash.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apply {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 活动ID
     */
    private Long activityId;
    /**
     * 报名人员名字
     */
    private String name;

    /**
     * 报名人员ID
     */
    private Long memberId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    public Apply(Long activityId, Long memberId) {
        this.activityId = activityId;
        this.memberId = memberId;
    }

}
