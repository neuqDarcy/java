package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.dto.reqeust.CreatePublishReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CreatePublishReqDtoAssembler {
    CreatePublishReqDtoAssembler INSTANCE = Mappers.getMapper(CreatePublishReqDtoAssembler.class);
    Publish toEntity(CreatePublishReqDto dto);
}
