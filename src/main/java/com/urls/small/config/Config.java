package com.urls.small.config;

import cn.hutool.core.util.ImageUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置文件
 * @author YI
 * @date 2018-10-19 10:16:51
 */
@Configuration
@PropertySource("classpath:config/config.properties")
public class Config {

    public static String key;

    public static String keyMd5;

    public static String keySina;

    public static String api;

    public static String source;

    public static String domain;

    /**
     * 生成二维码的长宽
     */
    public static int LENGTH_WIDTH = 200;

    public static String URL_HTTP = "http://";
    public static String URL_HTTPS = "https://";

    public static String getCreatePath(String fileName){
        return "/QrCode" + StrUtil.SLASH + fileName + StrUtil.DOT + ImageUtil.IMAGE_TYPE_JPG;
    }

    @Value("${key}")
    public void setKey(String key) {
        Config.key = key;
    }

    @Value("${keyMd5}")
    public void setKeyMd5(String keyMd5) {
        Config.keyMd5 = keyMd5;
    }

    @Value("${keySina}")
    public void setKeySina(String keySina) {
        Config.keySina = keySina;
    }

    @Value("${api}")
    public void setApi(String api) {
        Config.api = api;
    }

    @Value("${source}")
    public void setSource(String source) {
        Config.source = source;
    }

    @Value("${domain}")
    public void setDomain(String domain) {
        Config.domain = domain;
    }
}
