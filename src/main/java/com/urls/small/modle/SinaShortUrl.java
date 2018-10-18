package com.urls.small.modle;

import java.util.List;

/**
 * 新浪短链接转换bean
 * @author YI
 * @date 2018-10-11 19:04:23
 */
public class SinaShortUrl {
    private List<Urls> urls;

    public void setUrls(List<Urls> urls){
        this.urls = urls;
    }

    public List<Urls> getUrls(){
        return this.urls;
    }

    @Override
    public String toString() {
        return "SinaShortUrl{" +
                "urls=" + urls +
                '}';
    }
}
