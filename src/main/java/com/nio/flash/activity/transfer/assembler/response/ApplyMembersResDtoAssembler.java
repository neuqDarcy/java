package com.nio.flash.activity.transfer.assembler.response;

import com.nio.flash.activity.domain.Apply;
import com.nio.flash.activity.model.dto.response.ApplyMemberResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface ApplyMembersResDtoAssembler {
    ApplyMembersResDtoAssembler INSTANCE = Mappers.getMapper(ApplyMembersResDtoAssembler.class);
    ApplyMemberResDto toDto(Apply apply);
    List<ApplyMemberResDto> toDtoList(List<Apply> applyList);
}

