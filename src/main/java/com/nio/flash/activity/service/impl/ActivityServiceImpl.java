package com.nio.flash.activity.service.impl;

import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.infrastructure.repository.ActivityRepository;
import com.nio.flash.activity.model.DO.ActivityDO;
import com.nio.flash.activity.service.ActivityService;
import com.nio.flash.activity.transfer.converter.ActivityDoConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    private static final ActivityDoConverter ACTIVITY_DO_CONVERTER = ActivityDoConverter.INSTANCE;
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
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
}
