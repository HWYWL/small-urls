package com.urls.small.url;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.net.URLEncoder;

@Repository
@PropertySource("classpath:config/config.properties")
public class UrlDaoImpl implements UrlDao{

    private StringRedisTemplate stringRedisTemplate;
    private HashOperations hashOperations;
    @Value("${key}")
    private String key;
    @Value("${keyMd5}")
    private String keyMd5;
    @Value("${keySina}")
    private String keySina;
    @Value("${api}")
    private String api;
    @Value("${source}")
    private String source;

    @Override
    public void saveUrl(Url url) {
        hashOperations.put(key,url.getId(),url.getUrl());
    }

    @Override
    public Url getUrl(String id) {
        String url ;
        Object object = hashOperations.get(key,id);
        if (object==null){
            return null;
        }
        url = (String) object;
        Url u = new Url();
        u.setId(id);
        u.setUrl(url);
        return u;
    }

    @Override
    public String getSurl(String md5) {
        Object object = hashOperations.get(keyMd5,md5);
        if (object==null){
            return null;
        }
        return (String )object;
    }

    @Override
    public void saveSurl(String md5,String id) {
        hashOperations.put(keyMd5,md5,id);
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
    public SinaShortUrl getSinaShortUrl(String longUrl) {
        SinaShortUrl shortUrl = null;

        try {
            String url = new StringBuffer().append(api).append("source=").append(source).append("&url_long=").append(URLEncoder.encode(longUrl, "utf-8")).toString();
            String result = HttpUtil.get(url);
            shortUrl = JSONUtil.toBean(JSONUtil.parseObj(result), SinaShortUrl.class);

            hashOperations.put(keySina, IdUtil.simpleUUID(), shortUrl.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

        return shortUrl;
    }
}
