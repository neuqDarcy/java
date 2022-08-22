package com.nio.flash.activity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/status")
    public String getStatus() {
        return "success";
    }
}
