package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.Nioer;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.reqeust.NioerLoginReqDto;
import com.nio.flash.activity.model.dto.reqeust.UserLoginReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Allx
 * @Date 0031 8/31 9:59
 */
@Mapper
public interface NioerLoginReqDtoAssembler {
    NioerLoginReqDtoAssembler INSTANCE = Mappers.getMapper(NioerLoginReqDtoAssembler.class);

    Nioer toEntity(NioerLoginReqDto dto);
}
