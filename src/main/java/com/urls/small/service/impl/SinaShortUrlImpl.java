package com.urls.small.service.impl;

import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.urls.small.config.Config;
import com.urls.small.modle.SinaShortUrl;
import com.urls.small.service.SinaShortUrlService;
import com.urls.small.url.UrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        if(!longUrl.startsWith(Config.URL_HTTP) && !longUrl.startsWith(Config.URL_HTTPS)){
            longUrl = URLUtil.normalize(longUrl);
        }

        String url;
        SinaShortUrl shortUrl = null;
        try {
            url = Config.api + "source=" + Config.source + "&url_long=" + URLEncoder.encode(longUrl, "utf-8");
            String result = HttpUtil.get(url);
            shortUrl = JSONUtil.toBean(JSONUtil.parseObj(result), SinaShortUrl.class);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return urlDao.getSinaShortUrl(shortUrl);
    }
}
