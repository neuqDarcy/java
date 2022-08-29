package com.nio.flash.activity.transfer.assembler.response;

import com.nio.flash.activity.domain.Person;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.model.dto.response.UserProfileResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserProfileDTOAssembler {
    UserProfileDTOAssembler INSTANCE = Mappers.getMapper(UserProfileDTOAssembler.class);
    UserProfileResDto toDto(User user);
    UserProfileResDto toDto(Person person);
    User toEntity(UserProfileResDto userProfileResDto);
}

