package com.morgan.backendexamples.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

public interface InitService {
    @Transactional
    @EventListener(ApplicationReadyEvent.class)
//    创建表的时候同时创建一个管理员账户
    void init();
}
