package com.nio.flash.activity.model.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Allx
 * @Date 0030 8/30 21:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserLoginReqDto {
    /**
     * 电话，即账号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
