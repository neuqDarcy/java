package com.nio.flash.activity.transfer.converter;

import com.nio.flash.activity.annotation.MappingIgnore;
import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.model.DO.PublishDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PublishDoConverter {
    PublishDoConverter INSTANCE = Mappers.getMapper(PublishDoConverter.class);
    @MappingIgnore
    PublishDO toDo(Publish publish);
    @MappingIgnore
    List<PublishDO> toListDo(List<Publish> publishes);
    Publish toEntity(PublishDO publishDO);
    List<Publish> toEntities(List<PublishDO> publishDos);
}
