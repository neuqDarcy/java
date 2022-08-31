package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.reqeust.UserLoginReqDto;
import com.nio.flash.activity.model.dto.reqeust.UserRegisterReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Allx
 * @Date 0030 8/30 22:05
 */
@Mapper
public interface UserLoginReqDtoAssembler {
    UserLoginReqDtoAssembler INSTANCE = Mappers.getMapper(UserLoginReqDtoAssembler.class);

    User toEntity(UserLoginReqDto dto);
}
