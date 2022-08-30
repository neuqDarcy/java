package com.nio.flash.activity.service;

import com.nio.flash.activity.domain.Activity;

import java.util.List;

public interface ActivityService {
    void save(Activity activity);

    List<Activity> getList();

    Activity getById(Long id);
}
