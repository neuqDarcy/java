package com.nio.flash.activity.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FillDateConfig implements MetaObjectHandler {
    /**
     * 执行插入操作时，给 createTime 和 updateTime 赋值
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", System.currentTimeMillis(), metaObject);
        this.setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
    }

    /**
     * 执行更新操作时，给 updateTime 赋值
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", System.currentTimeMillis(), metaObject);
    }
}
