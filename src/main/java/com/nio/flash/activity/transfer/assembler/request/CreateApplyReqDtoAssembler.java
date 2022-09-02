package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.Apply;
import com.nio.flash.activity.model.dto.reqeust.CreateApplyReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreateApplyReqDtoAssembler {
    CreateApplyReqDtoAssembler INSTANCE = Mappers.getMapper(CreateApplyReqDtoAssembler.class);
    Apply toEntity(CreateApplyReqDto dto);
}
