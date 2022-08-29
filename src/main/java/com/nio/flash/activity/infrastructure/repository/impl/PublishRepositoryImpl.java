package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.PublishMapper;
import com.nio.flash.activity.infrastructure.repository.PublishRepository;
import com.nio.flash.activity.model.DO.PublishDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 发布事件表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class PublishRepositoryImpl extends ServiceImpl<PublishMapper, PublishDO> implements PublishRepository {

}
