package com.nio.flash.activity.transfer.converter;

import com.nio.flash.activity.annotation.MappingIgnore;
import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.model.DO.ActivityDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ActivityDoConverter {
    ActivityDoConverter INSTANCE = Mappers.getMapper(ActivityDoConverter.class);
    @MappingIgnore
    ActivityDO toDo(Activity activity);
    @MappingIgnore
    List<ActivityDO> toListDo(List<Activity> activities);
    Activity toEntity(ActivityDO activityDO);
    List<Activity> toEntities(List<ActivityDO> activityDOS);
}
