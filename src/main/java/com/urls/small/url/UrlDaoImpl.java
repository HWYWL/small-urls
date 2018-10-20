package com.urls.small.url;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.urls.small.config.Config;
import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Sm;
import com.urls.small.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.File;

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
        File file = FileUtil.touch(Config.getCreatePath(url.getId()));
        QrCodeUtil.generate(Config.domain + url.getId(), Config.LENGTH_WIDTH, Config.LENGTH_WIDTH, file);

        Sm sm = getSm(file);

        url.setQrCode(sm.getData().getUrl());

        hashOperations.put(Config.key, url.getId(), JSONUtil.toJsonStr(url));
    }

    @Override
    public Url getUrl(String id) {
        String json = (String)hashOperations.get(Config.key, id);

        return JSONUtil.toBean(json, Url.class);
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
        String simpleUUID = IdUtil.simpleUUID();
        File file = FileUtil.touch(Config.getCreatePath(simpleUUID));
        QrCodeUtil.generate(longUrl.getUrls().get(0).getUrl_short(), Config.LENGTH_WIDTH, Config.LENGTH_WIDTH, file);

        Sm sm = getSm(file);

        longUrl.getUrls().forEach(item -> item.setQrCode(sm.getData().getUrl()));

        hashOperations.put(Config.keySina, simpleUUID, JSONUtil.toJsonStr(longUrl.getUrls()));

        return longUrl;
    }

    /**
     * 把二维码上传到图床
     * @param file 二维码文件
     * @return
     */
    private Sm getSm(File file){
        HttpRequest request = HttpRequest
                .post("https://sm.ms/api/upload")
                .form("smfile", file)
                .form("ssl", false)
                .form("format", "json");
        HttpResponse response = request.execute();
        String body = response.body();

        return JSONUtil.toBean(body, Sm.class);
    }
}
