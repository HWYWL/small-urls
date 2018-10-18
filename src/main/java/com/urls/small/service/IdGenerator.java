package com.urls.small.service;

/**
 * redis id生成
 * @author YI
 * @date 2018-10-18 17:52:37
 */
public interface IdGenerator {
    /**
     * 获取下一个id
     * @return
     */
    Long next();

    /**
     * 初始化
     */
    void init();

}
