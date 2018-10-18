package com.urls.small.service.impl;

import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.urls.small.modle.Url;
import com.urls.small.service.UrlService;
import com.urls.small.url.UrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 本地短链接服务
 * @author YI
 * @date 2018-10-18 22:25:31
 */
@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    RedisIdGenerator redisIdGenerator;

    @Autowired
    UrlDao urlDao;

    @Override
    public Url getUrl(String id) {
        return urlDao.getUrl(id);
    }

    @Override
    public String saveUrl(Url url) {
        String lUrl = url.getUrl();
        if(!lUrl.startsWith("http://") &&! lUrl.startsWith("https://")){
            url.setUrl(URLUtil.normalize(lUrl));
        }

        // 计算url的md5
        String md5 = DigestUtil.md5Hex(url.getUrl());
        // 判断该md5是否已经存在
        String sUrl = urlDao.getSurl(md5);

        if(sUrl!=null){
            Url lurl = urlDao.getUrl(sUrl);
            if(lurl!=null&&lurl.getUrl().equals(url.getUrl())){
                return sUrl;
            }
        }

        Long l = redisIdGenerator.next();
        String id = Long.toString(l, 36);

        url.setId(id);
        urlDao.saveUrl(url);
        urlDao.saveSurl(md5,id);

        return id;
    }
}
