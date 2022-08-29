package com.nio.flash.activity;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.nio.flash.activity.infrastructure.mapper.ActivityMapper;
import com.nio.flash.activity.model.DO.ActivityDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MybatisPlusSampleTest {

    @Autowired
    private ActivityMapper sampleMapper;

    @Test
    void testInsert() {
//        ActivityDO sample = new ActivityDO();
//        sampleMapper.insert(sample);
        List<ActivityDO> sample = sampleMapper.selectList(null);
        assertThat(sample).isNotNull();
    }
}
