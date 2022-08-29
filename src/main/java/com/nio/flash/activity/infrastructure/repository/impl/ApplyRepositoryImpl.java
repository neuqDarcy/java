package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.ApplyMapper;
import com.nio.flash.activity.infrastructure.repository.ApplyRepository;
import com.nio.flash.activity.model.DO.ApplyDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报名表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class ApplyRepositoryImpl extends ServiceImpl<ApplyMapper, ApplyDO> implements ApplyRepository {

}
