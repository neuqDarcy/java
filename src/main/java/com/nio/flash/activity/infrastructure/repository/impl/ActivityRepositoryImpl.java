package com.nio.flash.activity.infrastructure.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.ActivityMapper;
import com.nio.flash.activity.infrastructure.repository.ActivityRepository;
import com.nio.flash.activity.model.DO.ActivityDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class ActivityRepositoryImpl extends ServiceImpl<ActivityMapper, ActivityDO> implements ActivityRepository {

}
