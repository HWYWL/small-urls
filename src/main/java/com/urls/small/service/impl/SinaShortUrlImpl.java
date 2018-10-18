package com.urls.small.service.impl;

import cn.hutool.core.util.URLUtil;
import com.urls.small.modle.SinaShortUrl;
import com.urls.small.service.SinaShortUrlService;
import com.urls.small.url.UrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 新浪短链接生成
 * @author YI
 * @date 2018-4-11 19:11:24
 */
@Service
public class SinaShortUrlImpl implements SinaShortUrlService {
    @Autowired
    UrlDao urlDao;

    @Override
    public SinaShortUrl getShortUrl(String longUrl) {
        if(!longUrl.startsWith("http://") && !longUrl.startsWith("https://")){
            longUrl = URLUtil.normalize(longUrl);
        }

        return urlDao.getSinaShortUrl(longUrl);
    }
}
