package com.nio.flash.activity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nio.flash.activity.infrastructure.mapper")
public class ActivityPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityPlatformApplication.class, args);
	}

}
