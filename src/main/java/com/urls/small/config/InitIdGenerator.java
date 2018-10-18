package com.urls.small.config;

import com.urls.small.service.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 初始化id生成器
 * @author YI
 * @date 2018-10-18 17:56:34
 */
@Component
public class InitIdGenerator implements ApplicationRunner {
    @Autowired
    IdGenerator idGenerator;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        idGenerator.init();
    }
}
