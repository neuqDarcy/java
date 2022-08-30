package com.nio.flash.activity.model.DO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * 活动表
 *
 * @author darcy
 * @since 2022-08-28
 */
@TableName("activity")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class ActivityDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 发起用户
     */
    private Long ownerId;
    /**
     * 活动名称
     */
    @TableField(value = "activity_name")
    private String name;
    /**
     * 活动简介
     */
    private String descr;

    /**
     * 帖子id
     */
    private String pgcId;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 地点
     */
    private String place;

    /**
     * 点赞量
     */
    private Long stars;

    /**
     * 活动状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateTime;

}
