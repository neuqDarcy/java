package com.nio.flash.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.sf.jsqlparser.util.validation.ValidationException;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    private long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String email;
    private String phone;
    private String address;
    private String avatar;
    private Integer status;
    private long createTime;
    private long updateTime;

    public void setAge(Integer age) {
        if (age < 0 || age > 120) {
            throw new ValidationException("invalid age");
        }
        this.age = age;
    }
}
