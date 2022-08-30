package com.nio.flash.activity.transfer.assembler.response;

import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.model.dto.response.ActivityDetailResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActivityDetailResDtoAssembler {
    ActivityDetailResDtoAssembler INSTANCE = Mappers.getMapper(ActivityDetailResDtoAssembler.class);
    ActivityDetailResDto toDto(Activity activity);
}

