package com.nio.flash.activity.model.dto.response;

import lombok.Data;

@Data
public class UserProfileResDto {
    private String name;
    private Integer age;
    private Integer sex;
    private String email;
    private String phone;
    private String address;
}
