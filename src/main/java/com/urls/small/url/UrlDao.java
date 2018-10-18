package com.urls.small.url;

import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;

public interface UrlDao {

    void saveUrl(Url url);

    Url getUrl(String id);

    String getSurl(String md5);

    void saveSurl(String md5, String id);

    /**
     * 获得新浪短链接
     * @param longUrl 长连接
     * @return
     */
    SinaShortUrl getSinaShortUrl(String longUrl);

}
