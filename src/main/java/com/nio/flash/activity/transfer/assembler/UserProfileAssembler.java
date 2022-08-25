package com.nio.flash.activity.transfer.assembler;

import com.nio.flash.activity.model.dto.UserProfileDto;
import com.nio.flash.activity.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserProfileAssembler {
    UserProfileAssembler INSTANCE = Mappers.getMapper(UserProfileAssembler.class);
    UserProfileDto toDto(User user);
    User toEntity(UserProfileDto userProfileDto);
}
