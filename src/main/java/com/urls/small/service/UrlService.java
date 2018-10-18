package com.urls.small.service;

import com.urls.small.modle.Url;

public interface UrlService {

    /**
     * 获取本地短链接
     * @param id redis id
     * @return
     */
    Url getUrl(String id);

    /**
     * 保存短链接到本地
     * @param url 本地连接
     * @return
     */
    String saveUrl(Url url);

}
