package com.nio.flash.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jsqlparser.util.validation.ValidationException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private long id;
    private long ownerId;
    private String name;
    private String descr;
    private String coverUrl;
    private String memberIds;
    private long pgcId;
    private long startTime;
    private long endTime;
    private String place;
    private String comments;
    private Integer stars;
    private Integer status;
    private long createTime;
    private long updateTime;

    public Activity setOwnerId(long ownerId) {
        if (ownerId <= 0) {
            throw new ValidationException("invalid owner_id");
        }
        this.ownerId = ownerId;
        return this;
    }

    public Activity setStartTime(long startTime) {
        if (startTime <= 0) {
            throw new ValidationException("invalid start_time");
        }
        this.startTime = startTime;
        return this;
    }

    public Activity setEndTime(long endTime) {
        if (endTime <= 0) {
            throw new ValidationException("invalid end_time");
        }
        this.endTime = endTime;
        return this;
    }
}
