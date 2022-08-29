package com.nio.flash.activity.infrastructure.repository.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nio.flash.activity.infrastructure.mapper.CommentMapper;
import com.nio.flash.activity.infrastructure.repository.CommentRepository;
import com.nio.flash.activity.model.DO.CommentDO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author darcy
 * @since 2022-08-29
 */
@Service
public class CommentRepositoryImpl extends ServiceImpl<CommentMapper, CommentDO> implements CommentRepository {

}
