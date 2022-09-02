package com.nio.flash.activity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础接口
 */
@RestController
public class BaseController {
    /**
     * 查询服务状态
     */
    @GetMapping("/status")
    public String getStatus() {
        return "开摆开摆";
    }
}
