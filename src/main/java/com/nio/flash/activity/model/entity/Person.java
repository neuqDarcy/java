package com.nio.flash.activity.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class Person {
    private long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String email;
    private String phone;
    private String address;
    private Integer status;
    private long createTime;
    private long updateTime;
}
