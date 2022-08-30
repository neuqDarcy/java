package com.nio.flash.activity.transfer.assembler.response;

import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.model.dto.response.ActivityBriefResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface ActivitiesBriefResDtoAssembler {
    ActivitiesBriefResDtoAssembler INSTANCE = Mappers.getMapper(ActivitiesBriefResDtoAssembler.class);
    ActivityBriefResDto toDto(Activity activity);
    List<ActivityBriefResDto> toDtoList(List<Activity> activities);
    Activity toEntity(ActivityBriefResDto activityBriefResDto);
}

