package com.urls.small.url;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.json.JSONUtil;
import com.urls.small.config.Config;
import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * 短链接获取和保存
 * @author YI
 * @date 2018-10-19 09:20:55
 */
@Repository
public class UrlDaoImpl implements UrlDao{

    private StringRedisTemplate stringRedisTemplate;

    private HashOperations hashOperations;

    @Override
    public void saveUrl(Url url) {
        QrCodeUtil.generate(Config.domain + url.getId(), 300, 300,
                FileUtil.touch("./QrCode" + StrUtil.SLASH + url.getId() + StrUtil.DOT + ImageUtil.IMAGE_TYPE_JPG));

        hashOperations.put(Config.key, url.getId(), url.getUrl());
    }

    @Override
    public Url getUrl(String id) {
        Url u = new Url();

        String url ;
        Object object = hashOperations.get(Config.key, id);

        url = (String) object;
        u.setId(id);
        u.setUrl(url);

        return u;
    }

    @Override
    public String getSurl(String md5) {
        Object object = hashOperations.get(Config.keyMd5, md5);

        return (String )object;
    }

    @Override
    public void saveSurl(String md5,String id) {
        hashOperations.put(Config.keyMd5, md5,id);
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
        hashOperations = this.stringRedisTemplate.opsForHash();
    }

    /**
     * 获得新浪短链接
     * @param longUrl
     * @return
     */
    @Override
    public SinaShortUrl getSinaShortUrl(SinaShortUrl longUrl) {
        hashOperations.put(Config.keySina, IdUtil.simpleUUID(), JSONUtil.toJsonStr(longUrl.getUrls()));

        return longUrl;
    }
}
