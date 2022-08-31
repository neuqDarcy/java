package com.nio.flash.activity.transfer.converter;

import com.nio.flash.activity.annotation.MappingIgnore;
import com.nio.flash.activity.domain.Nioer;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.DO.NioerDO;
import com.nio.flash.activity.model.DO.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Author Allx
 * @Date 0031 8/31 9:49
 */
@Mapper
public interface NioerDoConverter {
    NioerDoConverter INSTANCE = Mappers.getMapper(NioerDoConverter.class);
    @MappingIgnore
    NioerDO toDo(Nioer nioer);
    @MappingIgnore
    Nioer toEntity(NioerDO nioerDo);
}
