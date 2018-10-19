package com.urls.small.url;

import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;

/**
 * 短链接获取和保存
 * @author YI
 * @date 2018-10-19 09:20:55
 */
public interface UrlDao {

    /**
     * 保存本地短链接
     * @param url
     */
    void saveUrl(Url url);

    /**
     * 根据id获取本地短链接
     * @param id
     * @return
     */
    Url getUrl(String id);

    /**
     * 根据md5获取保存到redis的新浪短链接
     * @param md5
     * @return
     */
    String getSurl(String md5);

    /**
     * 保存新浪短链接到redis
     * @param md5
     * @param id
     */
    void saveSurl(String md5, String id);

    /**
     * 通过新浪接口获得新浪短链接
     * @param longUrl 长连接
     * @return
     */
    SinaShortUrl getSinaShortUrl(SinaShortUrl longUrl);

}
