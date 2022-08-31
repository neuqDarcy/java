package com.nio.flash.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nio.flash.activity.domain.Nioer;
import com.nio.flash.activity.infrastructure.repository.NioerRepository;
import com.nio.flash.activity.model.DO.NioerDO;
import com.nio.flash.activity.model.DO.UserDO;
import com.nio.flash.activity.service.NioerService;
import com.nio.flash.activity.transfer.converter.NioerDoConverter;
import org.springframework.stereotype.Service;

/**
 * @Author Allx
 * @Date 0031 8/31 9:46
 */
@Service
public class NioerServiceImpl implements NioerService {
    private static final NioerDoConverter NIOER_DO_CONVERTER = NioerDoConverter.INSTANCE;
    private final NioerRepository nioerRepository;

    public NioerServiceImpl(NioerRepository nioerRepository) {
        this.nioerRepository = nioerRepository;
    }

    @Override
    public boolean login(Nioer nioer) {
        NioerDO nioerDo = NIOER_DO_CONVERTER.toDo(nioer);
        LambdaQueryWrapper<NioerDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(NioerDO::getPhone, nioerDo.getPhone());
        wrapper.eq(NioerDO::getPassword, nioerDo.getPassword());
        NioerDO one = nioerRepository.getOne(wrapper);
        return one != null;
    }
}
