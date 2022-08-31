package com.nio.flash.activity.model.dto.reqeust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Allx
 * @Date 0031 8/31 10:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NioerLoginReqDto {
    /**
     * 电话，即账号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;
}
