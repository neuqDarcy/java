package com.nio.flash.activity.transfer.assembler.response;

import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.dto.response.PublishDetailResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface PublishResDtoAssembler {
    PublishResDtoAssembler INSTANCE = Mappers.getMapper(PublishResDtoAssembler.class);
    PublishDetailResDto toDto(Publish user);

    List<PublishDetailResDto> toDtoList(List<Publish> publishes);
    Publish toEntity(PublishDetailResDto publishDetailResDto);
}

