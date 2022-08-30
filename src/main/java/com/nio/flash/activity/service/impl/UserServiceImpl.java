package com.nio.flash.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.nio.flash.activity.domain.User;
import com.nio.flash.activity.infrastructure.repository.UserRepository;
import com.nio.flash.activity.model.DO.UserDO;
import com.nio.flash.activity.model.dto.response.UserProfileResDto;
import com.nio.flash.activity.service.UserService;
import com.nio.flash.activity.transfer.converter.UserDoConverter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final UserDoConverter USER_DO_CONVERTER = UserDoConverter.INSTANCE;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileResDto getUserProfile(long userId) {
        return null;
    }

    @Override
    public void save(User user) {
        UserDO userDo = USER_DO_CONVERTER.toDo(user);
//        UserDO userDo = new UserDO();
        userRepository.saveOrUpdate(userDo);
    }

    @Override
    public boolean login(User user) {
        UserDO userDo = USER_DO_CONVERTER.toDo(user);
        LambdaQueryWrapper<UserDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDO::getPhone, userDo.getPhone());
        wrapper.eq(UserDO::getPassword, userDo.getPassword());
        UserDO one = userRepository.getOne(wrapper);
        return one != null;
    }


}
