package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.model.dto.reqeust.CreateActivityReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateActivityReqDtoAssembler {
    CreateActivityReqDtoAssembler INSTANCE = Mappers.getMapper(CreateActivityReqDtoAssembler.class);
    Activity toEntity(CreateActivityReqDto dto);
}
