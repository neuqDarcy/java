package com.nio.flash.activity.service;

import com.nio.flash.activity.domain.Publish;

import java.util.List;

public interface PublishService {
    void save(Publish publish);

    Publish getDetailById(Long id);

    List<Publish> getList();
}
