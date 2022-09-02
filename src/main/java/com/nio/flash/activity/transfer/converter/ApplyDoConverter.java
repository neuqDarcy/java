package com.nio.flash.activity.transfer.converter;

import com.nio.flash.activity.annotation.MappingIgnore;
import com.nio.flash.activity.domain.Apply;
import com.nio.flash.activity.model.DO.ApplyDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ApplyDoConverter {
    ApplyDoConverter INSTANCE = Mappers.getMapper(ApplyDoConverter.class);
    @MappingIgnore
    ApplyDO toDo(Apply activity);
    @MappingIgnore
    List<ApplyDO> toListDo(List<Apply> applies);
    Apply toEntity(ApplyDO activityDO);
    List<Apply> toEntities(List<ApplyDO> activityDOs);
}
