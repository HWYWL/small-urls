package com.urls.small.service;

import com.urls.small.modle.SinaShortUrl;

/**
 * 新浪短链接接口
 * @author YI
 * @date 2018-4-11 19:33:44
 */
public interface SinaShortUrlService {
    /**
     * 通过新浪获取短链接
     * @param longUrl 长链接
     * @return
     */
    SinaShortUrl getShortUrl(String longUrl);
}
