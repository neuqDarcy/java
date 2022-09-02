package com.nio.flash.activity.service;

import com.nio.flash.activity.domain.Activity;
import com.nio.flash.activity.domain.Apply;

import java.util.List;

public interface ActivityService {
    Long save(Activity activity);

    List<Activity> getList();

    Activity getById(Long id);

    boolean apply(Apply apply);

    List<Apply> getApplyMembers(Long id);
}
