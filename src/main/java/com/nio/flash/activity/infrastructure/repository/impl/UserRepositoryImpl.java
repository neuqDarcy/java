package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.UserMapper;
import com.nio.flash.activity.infrastructure.repository.UserRepository;
import com.nio.flash.activity.model.DO.UserDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserDO> implements UserRepository {

}
