package com.nio.flash.activity.transfer.assembler.request;

import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.dto.reqeust.ModifyPublishReqDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModifyPublishReqDtoAssembler {
    ModifyPublishReqDtoAssembler INSTANCE = Mappers.getMapper(ModifyPublishReqDtoAssembler.class);
    Publish updateEntityFromDto(ModifyPublishReqDto dto, @MappingTarget Publish entity);
}
