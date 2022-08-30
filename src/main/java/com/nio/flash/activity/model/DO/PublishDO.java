package com.nio.flash.activity.model.DO;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 发布事件表
 * </p>
 *
 * @author darcy
 * @since 2022-08-28
 */
@TableName("publish")
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublishDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 活动ID
     */
    private Long activityId;

    /**
     * 员工ID
     */
    private Long staffId;

    /**
     * 状态,0-进行中,1-审核通过,2-活动结束
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
