package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.NioerMapper;
import com.nio.flash.activity.infrastructure.repository.NioerRepository;
import com.nio.flash.activity.model.DO.NioerDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 蔚来员工表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class NioerRepositoryImpl extends ServiceImpl<NioerMapper, NioerDO> implements NioerRepository {

}
