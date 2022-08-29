package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.reqeust.UserRegisterReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRegisterReqDtoAssembler {
    UserRegisterReqDtoAssembler INSTANCE = Mappers.getMapper(UserRegisterReqDtoAssembler.class);
    User toEntity(UserRegisterReqDto dto);
}
