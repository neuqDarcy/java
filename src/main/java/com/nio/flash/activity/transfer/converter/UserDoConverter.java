package com.nio.flash.activity.transfer.converter;

import com.nio.flash.activity.annotation.MappingIgnore;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.DO.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDoConverter {
    UserDoConverter INSTANCE = Mappers.getMapper(UserDoConverter.class);
    @MappingIgnore
    UserDO toDo(User user);
    @MappingIgnore
    User toEntity(UserDO userDo);
}
