package com.nio.flash.activity.service.impl;

import com.nio.flash.activity.domain.Publish;
import com.nio.flash.activity.infrastructure.repository.PublishRepository;
import com.nio.flash.activity.model.DO.PublishDO;
import com.nio.flash.activity.service.PublishService;
import com.nio.flash.activity.transfer.converter.PublishDoConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishServiceImpl implements PublishService {
    public static final PublishDoConverter PUBLISH_DO_CONVERTER = PublishDoConverter.INSTANCE;
    PublishRepository publishRepository;

    public PublishServiceImpl(PublishRepository publishRepository) {
        this.publishRepository = publishRepository;
    }

    @Override
    public void save(Publish publish) {
        PublishDO publishDO = PUBLISH_DO_CONVERTER.toDo(publish);
        if (null != publish.getId()) {
            publishDO.setId(publish.getId());
        }
        publishRepository.saveOrUpdate(publishDO);
    }

    @Override
    public Publish getDetailById(Long id) {
        PublishDO publishDo = publishRepository.getById(id);
        return PUBLISH_DO_CONVERTER.toEntity(publishDo);
    }

    @Override
    public List<Publish> getList() {
        List<PublishDO> publishDos = publishRepository.list();
        return PUBLISH_DO_CONVERTER.toEntities(publishDos);
    }
}
