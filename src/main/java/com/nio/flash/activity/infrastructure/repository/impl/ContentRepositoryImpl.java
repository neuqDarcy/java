package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.ContentMapper;
import com.nio.flash.activity.infrastructure.repository.ContentRepository;
import com.nio.flash.activity.model.DO.ContentDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class ContentRepositoryImpl extends ServiceImpl<ContentMapper, ContentDO> implements ContentRepository {

}
