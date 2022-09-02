package com.nio.flash.activity.service.impl;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.domain.Apply;
import com.nio.flash.activity.infrastructure.mapper.ApplyMapper;
import com.nio.flash.activity.infrastructure.repository.ActivityRepository;
import com.nio.flash.activity.infrastructure.repository.ApplyRepository;
import com.nio.flash.activity.infrastructure.repository.UserRepository;
import com.nio.flash.activity.model.DO.ActivityDO;
import com.nio.flash.activity.model.DO.ApplyDO;
import com.nio.flash.activity.model.DO.UserDO;
import com.nio.flash.activity.service.ActivityService;
import com.nio.flash.activity.transfer.converter.ActivityDoConverter;
import com.nio.flash.activity.transfer.converter.ApplyDoConverter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private static final ActivityDoConverter ACTIVITY_DO_CONVERTER = ActivityDoConverter.INSTANCE;
    private static final ApplyDoConverter APPLY_DO_CONVERTER = ApplyDoConverter.INSTANCE;
    private final ActivityRepository activityRepository;
    private final ApplyRepository applyRepository;
    private final ApplyMapper applyMapper;
    private final UserRepository userRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository, ApplyRepository applyRepository, ApplyMapper applyMapper, UserRepository userRepository) {
        this.activityRepository = activityRepository;
        this.applyRepository = applyRepository;
        this.applyMapper = applyMapper;
        this.userRepository = userRepository;
    }

    @Override
    public Long save(Activity activity) {
        ActivityDO activityDO = ACTIVITY_DO_CONVERTER.toDo(activity);
        activityRepository.saveOrUpdate(activityDO);
        return activityDO.getId();
    }

    @Override
    public List<Activity> getList() {
        List<ActivityDO> list = activityRepository.list();
        return ACTIVITY_DO_CONVERTER.toEntities(list);
    }

    @Override
    public Activity getById(Long id) {
        ActivityDO activityDO = activityRepository.getById(id);
        return ACTIVITY_DO_CONVERTER.toEntity(activityDO);
    }

    @Override
    public boolean apply(Apply apply) {
        ApplyDO applyDO = APPLY_DO_CONVERTER.toDo(apply);
        return applyRepository.save(applyDO);
    }

    @Override
    public List<Apply> getApplyMembers(Long id) {
        List<ApplyDO> applyDos = new LambdaQueryChainWrapper<>(applyMapper).eq(ApplyDO::getActivityId, id).list();
        List<Apply> list = new ArrayList<>();
        for (Apply entity : APPLY_DO_CONVERTER.toEntities(applyDos)) {
            UserDO user = userRepository.getById(entity.getMemberId());
            entity.setName(null == user ? StringUtils.EMPTY : user.getName());
            list.add(entity);
        }
        return list;
    }
}
