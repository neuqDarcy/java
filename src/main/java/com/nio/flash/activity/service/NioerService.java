package com.nio.flash.activity.service;

import com.nio.flash.activity.domain.Nioer;
import org.springframework.stereotype.Service;

@Service
public interface NioerService {
    boolean login(Nioer nioer);
}
